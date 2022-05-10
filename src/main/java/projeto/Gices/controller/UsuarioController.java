package projeto.Gices.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.Gices.model.Usuario;
import projeto.Gices.repository.ConteudoRepository;
import projeto.Gices.repository.UsuarioRepository;
import projeto.Gices.security.ImplementsAdministratorDetailsService;

/**
 *
 * @author analice
 */
@Controller
@RequestMapping("")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    //private ImplementsAdministratorDetailsService usuarioService;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
    //(ImplementsAdministratorDetailsService usuarioService) {this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/cadastro")
    public String showRegistrationForm(Model model, Usuario usuario) {
        // model.addAttribute("usuario", usuario);
        model.addAttribute(usuario);
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String registerUserAccount(@Valid Usuario usuario, BindingResult result) {
        usuarioRepository.save(usuario);//usuarioService
        return "redirect:/index";
    }
    /*@PostMapping("/cadastro")
    public ResponseEntity<Usuario> teste(@Valid @RequestBody Usuario usuario, BindingResult result) {
        return ResponseEntity.ok(usuarioService.save(usuario));          
    }*/

}
