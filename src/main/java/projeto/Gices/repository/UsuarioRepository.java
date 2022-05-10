package projeto.Gices.repository;

import projeto.Gices.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author analice
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
