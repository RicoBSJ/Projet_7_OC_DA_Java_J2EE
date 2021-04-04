package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.ERole;
import com.aubrun.eric.projet7.beans.Role;
import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.beans.payload.request.LoginRequest;
import com.aubrun.eric.projet7.beans.payload.request.SignupRequest;
import com.aubrun.eric.projet7.beans.payload.response.JwtResponse;
import com.aubrun.eric.projet7.beans.payload.response.MessageResponse;
import com.aubrun.eric.projet7.business.mapper.UserAccountDtoMapper;
import com.aubrun.eric.projet7.business.security.JwtUtils;
import com.aubrun.eric.projet7.business.service.RoleService;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import com.aubrun.eric.projet7.business.service.UserDetailsImpl;
import com.aubrun.eric.projet7.business.service.exception.WrongIdentifier;
import com.aubrun.eric.projet7.consumer.repository.RoleRepository;
import com.aubrun.eric.projet7.consumer.repository.UserAccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserAccountService userAccountService;

    private final RoleService roleService;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserAccountService userAccountService, RoleService roleService, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userAccountService = userAccountService;
        this.roleService = roleService;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new WrongIdentifier();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userAccountService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userAccountService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        UserAccount user = new UserAccount(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleService.findByRoleName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByRoleName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleService.findByRoleName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleService.findByRoleName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userAccountService.save(UserAccountDtoMapper.toDto(user));

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}