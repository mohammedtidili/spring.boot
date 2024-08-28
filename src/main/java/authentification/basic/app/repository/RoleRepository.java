package authentification.basic.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import authentification.basic.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
