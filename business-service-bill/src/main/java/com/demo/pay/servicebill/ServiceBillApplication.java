package com.demo.pay.servicebill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		com.fisi.unmsm.database.model.entity.ServiceBill.class,
})
public class ServiceBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBillApplication.class, args);
	}

}
