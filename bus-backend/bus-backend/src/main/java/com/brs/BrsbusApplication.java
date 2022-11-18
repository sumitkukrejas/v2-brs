package com.brs;

import com.brs.repository.IUsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = IUsersRepository.class)
public class BrsbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrsbusApplication.class, args);
	}

}


