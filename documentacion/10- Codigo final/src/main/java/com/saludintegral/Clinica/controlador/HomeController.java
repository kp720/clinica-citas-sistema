package com.saludintegral.Clinica.controlador;


import com.saludintegral.Clinica.servicios.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private final DoctorService doctorService;

    //Constructor
    public HomeController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    //Redirección al login
    @GetMapping("/")
    public String inicio() {
        return "redirect:/login";
    }

    // Vista del formulario login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    // Redirección despues del login
    @GetMapping("/default")
    public String defaultAfterLogin(Authentication auth) {

        String rol = auth.getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        switch (rol) {
            case "ROLE_ADMIN":
                return "redirect:/admin/home";

            case "ROLE_DOCTOR":
                return "redirect:/doctor/home";

            case "ROLE_ENCARGADO":
                return "redirect:/encargado/home";

            default:
                return "redirect:/login?error";
        }
    }
}