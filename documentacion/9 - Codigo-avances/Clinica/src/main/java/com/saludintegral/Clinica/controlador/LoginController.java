package com.saludintegral.Clinica.controlador;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        switch (role) {
            case "ROLE_ADMIN": return "redirect:/admin/home";
            case "ROLE_DOCTOR": return "redirect:/doctor/home";
            case "ROLE_ENCARGADO": return "redirect:/encargado/home";
            default: return "redirect:/login?error";
        }
    }
}