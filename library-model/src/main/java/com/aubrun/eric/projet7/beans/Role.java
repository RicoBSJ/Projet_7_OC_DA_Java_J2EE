package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="user_role_id_generator", sequenceName = "user_role_id_seq", allocationSize=1)
@Table(name = "USER_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_role_id_generator")
    @Column(name = "id_role")
    private Integer roleId;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role_name")
    private ERole roleName;

    public Role() {
    }

    public Role(Integer roleId, ERole roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName=" + roleName +
                '}';
    }
}
