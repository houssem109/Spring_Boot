package com.houssem.pcs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.service.PcService;

@SpringBootApplication
public class PcsApplication implements CommandLineRunner {

	@Autowired
	PcService pcService;
	
	public static void main(String[] args) {
		SpringApplication.run(PcsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
