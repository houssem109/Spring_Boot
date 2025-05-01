package com.houssem.pcs;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.houssem.pcs.entities.Marque;
import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.entities.Role;
import com.houssem.pcs.entities.User;
import com.houssem.pcs.service.PcService;
import com.houssem.pcs.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PcsApplication implements CommandLineRunner {

	@Autowired
	PcService pcService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(PcsApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
	

	/*@PostConstruct
	void init_users() {
		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));
		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "houssem", "123", true, null));
		userService.saveUser(new User(null, "user1", "123", true, null));
		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("houssem", "USER");
		userService.addRoleToUser("houssem", "AGENT");
		userService.addRoleToUser("user1", "USER");
	}
*/
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Pc.class, Marque.class);

		/*
		 * pcService.savePc(new Pc("test3yo", "test", "test", 0, 0, "test", "test", 0,
		 * new Date(), "test")); pcService.savePc(new Pc("test2xa", "test", "test", 0,
		 * 0, "test", "test", 0, new Date(), "test"));
		 * 
		 * pcService.savePc(new Pc("test1aa", "test", "test", 0, 0, "test", "test", 0,
		 * new Date(), "test"));
		 */
		// System.out.println("Password Encoded BCRYPT :******************** ");
		// System.out.println(passwordEncoder.encode("123"));

	}

}
