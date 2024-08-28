package authentification.basic.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import authentification.basic.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByLastName(String lastName);
}
