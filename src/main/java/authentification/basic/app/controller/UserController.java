package authentification.basic.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import authentification.basic.app.model.User;
import authentification.basic.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody @Valid User user) {
		User userEx = userService.find(user);
		if (userEx != null) {
			return ResponseEntity.ok("User already taken : " + "\n" + "FirstName : " + user.getFirstName() + "\n"
					+ "LastName : " + user.getLastName());
		} else {
			userService.save(user);

			return ResponseEntity.ok("User saved correctly" + "\n" + "FirstName : " + user.getFirstName() + "\n"
					+ "LastName : " + user.getLastName());
		}
	}

	@GetMapping("/find")
	public ResponseEntity<User> find(@RequestBody User user) {

		return ResponseEntity.ok(userService.find(user));
	}

	@PutMapping("/put")
	public ResponseEntity<String> update(@RequestBody @Valid User user) {

		return new ResponseEntity<>("User updated with success", HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody @Valid User user) {
		if (user != null) {
			userService.delete(user);
			return new ResponseEntity<>("User deleted with success", HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<>("User not deleted (NOT FOUND)", HttpStatus.ACCEPTED);

		}
	}

	@GetMapping("/findAll")
	public List<User> findAll() {
		return userService.findAll();
	}

}
