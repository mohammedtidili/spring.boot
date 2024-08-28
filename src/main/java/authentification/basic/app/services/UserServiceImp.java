package authentification.basic.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import authentification.basic.app.model.User;
import authentification.basic.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		User userEx = find(user);
		if (userEx != null) {
			return null;
		} else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		}
	}

	@Override
	public User find(User user) {

		return userRepository.findByLastName(user.getLastName());

	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();

	}

	@Override
	public User update(User user) {
		if (user != null) {
			User userEX = find(user);
			userEX.setFirstName(user.getFirstName());
			userEX.setLastName(user.getLastName());
			userEX.setPassword(userEX.getPassword());
			userEX.setRoles(user.getRoles());
			userEX.setEmail(user.getEmail());
		}
		return null;
	}

	@Override
	public void delete(User user) {

		if (user != null) {
			userRepository.deleteById(user.getId());
		} else {
			System.out.println("User not found !!!! ");
		}
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByLastName(username);
//		System.out.println(user);
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				user.getAuthorities());
//
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userRepository.findByLastName(username);

	}

}
