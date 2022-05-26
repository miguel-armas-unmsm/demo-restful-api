package com.demo.pay.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		com.fisi.unmsm.database.model.entity.ServiceProvider.class
})
public class ServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderApplication.class, args);
	}

}
