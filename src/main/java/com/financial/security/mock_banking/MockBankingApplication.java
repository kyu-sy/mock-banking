package com.financial.security.mock_banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.financial.security.mock_banking.domain")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MockBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockBankingApplication.class, args);
	}

}
