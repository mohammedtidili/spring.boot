package authentification.basic.app.services;


import authentification.basic.app.model.Role;

public interface RoleService {
	Role save(Role role);

	Role find(Role role);

	Role update(Role role);

	void delete(Role role);

}
