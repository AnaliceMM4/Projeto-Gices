package projeto.Gices.controller;

import javax.validation.Valid;
import projeto.Gices.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projeto.Gices.repository.ConteudoRepository;
import projeto.Gices.repository.AdministratorRepository;
import projeto.Gices.security.ImplementsAdministratorDetailsService;

/**
 *
 * @author analice
 */
@Controller
@RequestMapping("/admin")
public class AdministratorController {

    private ImplementsAdministratorDetailsService administratorService;
    private ConteudoRepository conteudoRepository;
    private AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorController(ImplementsAdministratorDetailsService administratorService, ConteudoRepository conteudoRepository, AdministratorRepository administratorRepository) {
        this.administratorService = administratorService;
        this.conteudoRepository = conteudoRepository;
        this.administratorRepository = administratorRepository;
    }

    @GetMapping("/cadastroadmin")
    public String showRegistrationForm(Model model, Administrator administrator) {
        model.addAttribute(administrator);
        return "cadastroadmin";
    }

    @PostMapping("/cadastroadmin")
    public String registerUserAccount(@Valid Administrator administrator, BindingResult result) {
        administratorService.save(administrator);
        return "redirect:/login-admin";
    }
   
   
}
