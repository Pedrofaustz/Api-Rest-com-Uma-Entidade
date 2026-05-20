package pedroH.ApiRest.Repository;

import pedroH.ApiRest.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
}