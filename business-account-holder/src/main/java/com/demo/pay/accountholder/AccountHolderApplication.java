package com.demo.pay.accountholder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		com.fisi.unmsm.database.model.entity.Holder.class,
})
public class AccountHolderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountHolderApplication.class, args);
	}

}
