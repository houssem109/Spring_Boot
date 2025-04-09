package com.houssem.pcs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.houssem.pcs.entities.Marque;
import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.service.PcService;

@SpringBootApplication
public class PcsApplication implements CommandLineRunner {

	@Autowired
	PcService pcService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(PcsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Pc.class,Marque.class);		

		/*
		 * pcService.savePc(new Pc("test3yo", "test", "test", 0, 0, "test", "test", 0,
		 * new Date(), "test")); pcService.savePc(new Pc("test2xa", "test", "test", 0,
		 * 0, "test", "test", 0, new Date(), "test"));
		 * 
		 * pcService.savePc(new Pc("test1aa", "test", "test", 0, 0, "test", "test", 0,
		 * new Date(), "test"));
		 */

	}

}
