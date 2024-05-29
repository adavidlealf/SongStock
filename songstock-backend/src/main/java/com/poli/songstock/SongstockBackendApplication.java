package com.poli.songstock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.poli.songstock.business.CredentialsBusiness;

@SpringBootApplication
public class SongstockBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongstockBackendApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            CredentialsBusiness credentialsBusiness = ctx.getBean(CredentialsBusiness.class);
            boolean b = credentialsBusiness.createDefaultRoles();
            System.out.println("----- Creacion de roles: "+ b);
        };
    }
}
