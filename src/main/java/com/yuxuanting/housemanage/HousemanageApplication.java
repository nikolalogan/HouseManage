package com.yuxuanting.housemanage;

import com.yuxuanting.housemanage.dao.core.impl.BaseDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseDaoImpl.class)
public class HousemanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HousemanageApplication.class, args);
	}
}
