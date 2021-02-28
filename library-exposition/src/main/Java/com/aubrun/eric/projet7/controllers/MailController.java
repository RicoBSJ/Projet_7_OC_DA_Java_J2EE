package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/mail")
public class MailController {

    public final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Value("${attachment.invoice}")
    private String attachmentPath;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);

    }

    @RequestMapping(method = RequestMethod.GET)
    public String showEmailsPage() {
        return "emails";
    }

    @RequestMapping(value = {"/send", "/sendTemplate", "/sendAttachment"}, method = RequestMethod.GET)
    public String createMail(Model model,
                             HttpServletRequest request) {
        String action = request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1
        );
        Map<String, String> props = labels.get(action);
        Set<String> keys = props.keySet();
        for (String key : keys) {
            model.addAttribute(key, props.get(key));
        }

        model.addAttribute("mailObject", new MailObject());
        return "mail/send";
    }
}