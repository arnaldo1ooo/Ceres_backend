package com.ragnarok.ceres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching	//Habilita el Spring Cache
@SpringBootApplication
public class CeresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeresApplication.class, args);
	}

}
