package projeto.Gices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author analice
 */
@Controller
public class SecurityController {
    
    @GetMapping("/index")
    public String index(){
        return "index";
    }    
    
    @GetMapping("/")
    public String mostrar() {
        return "redirect:/index";
    }
 
    @GetMapping("/login-admin")
    public String loginAdmin() {
        return "login-admin";
    }

}
