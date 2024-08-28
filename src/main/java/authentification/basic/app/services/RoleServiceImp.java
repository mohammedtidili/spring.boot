package authentification.basic.app.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import authentification.basic.app.model.Role;
import authentification.basic.app.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(null);
	}

	@Override
	public Role find(Role role) {
		Role roleEx = roleRepository.findById(role.getId()).orElseThrow(() -> new NoSuchElementException("Role not found with ID: " + role.getId()));;
		return roleEx;
	}

	@Override
	public Role update(Role role) {
		return null;
	}

	@Override
	public void delete(Role role) {

	}

}
