package com.se.hmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableTransactionManagement
public class HmsBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsBackEndApplication.class, args);
	}

}
