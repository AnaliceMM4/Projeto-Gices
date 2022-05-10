/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package projeto.Gices.controller;

import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projeto.Gices.model.Administrator;
import projeto.Gices.repository.AdministratorRepository;

/**
 *
 * @author anali
 */

/*@Controller
@RequestMapping("/lives/")
public class LivesController {

    private LivesRepository livesRepository;
    private AdministratorRepository administratorRepository;

    @Autowired
    public LivesController(LivesRepository livesRepository, AdministratorRepository administratorRepository) {
        this.LivesRepository = livesRepository;
        this.administratorRepository = administratorRepository;
    }

    @GetMapping("cadastrar")
    public String showSignUpForm(Live live, Model model) {

        model.addAttribute("lives", livesRepository.findAll());
        return "lives";
    }

    @GetMapping("mostrar")
    public String showUpdateForm(Model model) {

        model.addAttribute("jogos", livesRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addGame(@Valid Live live, BindingResult result, Model model, Principal principal) {
        Administrator admin = administratorRepository.findByLogin(principal.getName());
        live.setAdministrator(admin);

        livesRepository.save(live);
        return "redirect:mostrar";
    }

    @GetMapping("editar/{codLive}")
    public String showUpdateForm(@PathVariable("codLive") int codLive, Model model, Principal principal) {
        Live live = livesRepository.findById(codLive)
                .orElseThrow(() -> new IllegalArgumentException("O código do jogo é inválido:" + codLive));
        if (live.getAdministrator().getLogin().equals(principal.getName())) {
            model.addAttribute("live", live);
            return "lives";
        } else {
            return "redirect:/403";
        }

    }

    @PostMapping("update/{codLive}")
    public String updateGame(@PathVariable("codLive") int codLive, @Valid Live live, Model model, Principal principal) {
        Administrator admin = administratorRepository.findByLogin(principal.getName());
        live.setAdministrator(admin);
        livesRepository.save(live);
        return "redirect:/lives";
    }

    @GetMapping("remover/{codLive}")
    public String deleteGame(@PathVariable("codLive") int codJogo, Model model, Principal principal) {
        Live live = livesRepository.findById(codJogo)
                .orElseThrow(() -> new IllegalArgumentException("O código da live é inválido:" + codLive));

        if (live.getUsuario().getLogin().equals(principal.getName())) {
            List<Administrator> administrator = (List) administratorRepository.findAll();
            for (Administrator admin : administrator) {
                admin.getLives().remove(live);
            }
            livesRepository.delete(live);
            return "redirect:/lives";
        } else {
            return "redirect:/403";
        }
    }

}*/
