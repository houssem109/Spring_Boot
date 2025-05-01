package com.houssem.pcs.service;

import com.houssem.pcs.entities.Role;
import com.houssem.pcs.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);

}
