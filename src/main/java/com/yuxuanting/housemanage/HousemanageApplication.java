package com.yuxuanting.housemanage;

import com.nikolalogan.common.core.controller.filter.ExceptionControllerAdvice;
import com.nikolalogan.common.core.controller.filter.ResponseControllerAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = com.nikolalogan.common.core.reponsitory.dao.impl.BaseDaoImpl.class)
@ComponentScans(value = {
		@ComponentScan(value = "com.nikolalogan.common.core.controller",includeFilters = {
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {ExceptionControllerAdvice.class, ResponseControllerAdvice.class})
		})
}
)
public class HousemanageApplication {
	public static void main(String[] args) {
		SpringApplication.run(HousemanageApplication.class, args);
	}
}
