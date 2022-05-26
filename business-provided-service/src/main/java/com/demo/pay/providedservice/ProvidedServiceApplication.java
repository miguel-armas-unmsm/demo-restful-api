package com.demo.pay.providedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		com.fisi.unmsm.database.model.entity.ProvidedService.class,
		com.fisi.unmsm.database.model.entity.Account.class,
})
public class ProvidedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvidedServiceApplication.class, args);
	}

}
