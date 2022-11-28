package com.brs;

import com.brs.repository.IUsersRepository;
import lombok.EqualsAndHashCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
//@EnableJpaRepositories(basePackageClasses = IUsersRepository.class)
public class BrsbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrsbusApplication.class, args);
	}

}


