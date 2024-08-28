package authentification.basic.app.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import authentification.basic.app.model.User;

public interface UserService extends UserDetailsService{

	User save(User user);

	User find(User user);

	User update(User user);

	void delete(User user);

	List<User> findAll();

}
