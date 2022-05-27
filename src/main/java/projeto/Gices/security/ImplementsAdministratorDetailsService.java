package projeto.Gices.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import projeto.Gices.model.Administrator;
import projeto.Gices.model.Role;
import projeto.Gices.model.Usuario;
import projeto.Gices.repository.AdministratorRepository;
import projeto.Gices.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
/**
 *
 * @author analice
 */
@Repository
@Transactional
public class ImplementsAdministratorDetailsService implements UserDetailsService {

    @Autowired
    private AdministratorRepository ar;
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Administrator administrator = ar.findByLogin(login);
        System.out.println("DeuCerto");
        if (administrator == null) {
            throw new UsernameNotFoundException("Administrador não encontrado!");
        }
        // return administrator;
        return new User(administrator.getLogin(), administrator.getSenha(), true, true, true, true, administrator.getAuthorities());
    }

    //salva o administrator no banco de dados
    public Administrator save(Administrator admin) {
        Administrator administrator = new Administrator();
        administrator.setNome(admin.getNome());
        administrator.setEmail(admin.getEmail());
        administrator.setLogin(admin.getLogin());
        administrator.setSenha(new BCryptPasswordEncoder().encode(admin.getSenha()));
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_ADMIN"));
        administrator.setRoles(roles);

        return ar.save(admin);//só uma vez
    }

    //salva o usuario no banco de dados
    public Usuario save(Usuario user) {
  /*  Usuario usuario = new Usuario();
      usuario.setNome(usuario.getNome());
      usuario.setTelefone(usuario.getTelefone());
      usuario.setEmail(usuario.getEmail());*/
        try {
            return ur.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
     // return usuario;
    }
}
