package com.ardaklc.SpringSecuritySix;

import com.ardaklc.SpringSecuritySix.model.User;
import com.ardaklc.SpringSecuritySix.model.UserRole;
import com.ardaklc.SpringSecuritySix.repository.UserRepository;
import com.ardaklc.SpringSecuritySix.repository.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringSecuritySixApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;

	public SpringSecuritySixApplication(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserRole ROLE_ADMIN = new UserRole(
				"ROLE_ADMIN"
		);
		UserRole ROLE_USER = new UserRole(
				"ROLE_USER"
		);
		userRoleRepository.save(ROLE_ADMIN);
		userRoleRepository.save(ROLE_USER);

		User FIRST_USER = new User(
				"{noop}1234",
				"created-admin",
				List.of(ROLE_ADMIN)
		);
		userRepository.save(FIRST_USER);

		User SECOND_USER = new User(
				"{noop}1234",
				"created-user",
				List.of(ROLE_USER)
		);
		userRepository.save(SECOND_USER);


	}
}
