package projeto.Gices.repository;

import projeto.Gices.model.Role;
import projeto.Gices.model.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author analice
 */
@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

    Administrator findByLogin(String login);
}
