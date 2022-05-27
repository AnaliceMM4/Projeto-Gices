package projeto.Gices.controller;

import projeto.Gices.model.Administrator;
import projeto.Gices.model.Conteudo;
import projeto.Gices.repository.AdministratorRepository;
import projeto.Gices.repository.ConteudoRepository;
import java.security.Principal;
import java.util.ArrayList;
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

/**
 *
 * @author analice
 */
@Controller
@RequestMapping("")
public class ConteudoController {

    private ConteudoRepository ConteudoRepository;
    private AdministratorRepository administratorRepository;

    @Autowired
    public ConteudoController(ConteudoRepository ConteudoRepository, AdministratorRepository administratorRepository) {
        this.ConteudoRepository = ConteudoRepository;
        this.administratorRepository = administratorRepository;
    }

    @GetMapping("cadastrar")
    public String showSignUpForm(Conteudo conteudo, Model model) {

        model.addAttribute("conteudos", ConteudoRepository.findAll());
        return "";
    }

    @GetMapping("/o-que-e")
    public String showOquee(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "o-que-e";
    }

    @GetMapping("/legislacao")
    public String showLegislacao(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "legislacao";
    }

    @GetMapping("/deficientes-visuais")
    public String showDeficientesVisuais(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "deficientes-visuais";
    }

    @GetMapping("/processo-de-ensino-aprendizagem")
    public String showProcessoEnsinoAprendizagem(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "processo-de-ensino-aprendizagem";
    }

    @GetMapping("/depoimentos-professores")
    public String showDepoimentosProfessores(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "professores";
    }
    
    @GetMapping("/depoimentos-alunos-e-egressos")
    public String showDepoimentosAlunosEgressos(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "alunos";
    }
    
    @GetMapping("/recursos-classicos")
    public String showRecursosTecnologicos(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "classicos";
    }

    @GetMapping("/recursos-alternativos")
    public String showMateriaisConcretos(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "alternativos";
    }

    @GetMapping("/lives")
    public String showlives(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "lives";
    }

    @GetMapping("/grupo-de-pesquisa")
    public String showGrupoDePesquisa(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "grupo-de-pesquisa";
    }

    @GetMapping("/acessibilidade")
    public String showAcessibilidade(Model model, Conteudo conteudo) {
        model.addAttribute("conteudos", conteudo);
        return "acessibilidade";
    }

    @PostMapping("addTextOqueE")
    public String addTextOqueE(@Valid Conteudo conteudo, BindingResult result, Model model, Principal principal) {
        Administrator admin = administratorRepository.findByLogin(principal.getName());
        conteudo.setAdministrator(admin);
        ConteudoRepository.save(conteudo);
        return "redirect:o-que-e";
    }

    @GetMapping("editar/{codConteudo}")
    public String showUpdateOqueE(@PathVariable("codConteudo") int codConteudo, Model model, Principal principal) {
        Conteudo conteudo = ConteudoRepository.findById(codConteudo)
                .orElseThrow(() -> new IllegalArgumentException("O código do texto é inválido:" + codConteudo));
        if (conteudo.getAdministrator().getLogin().equals(principal.getName())) {
            model.addAttribute("conteudo", conteudo);
            return "o-que-e";
        } else {
            return "redirect:";//Aqui deverá ter a página 403
        }
    }

    @PostMapping("update/{codConteudo}")
    public String updateOqueE(@PathVariable("codConteudo") int codConteudo, @Valid Conteudo conteudo, Model model, Principal principal) {
        Administrator admin = administratorRepository.findByLogin(principal.getName());
        conteudo.setAdministrator(admin);
        ConteudoRepository.save(conteudo);
        return "redirect:/o-que-e";
    }
}
