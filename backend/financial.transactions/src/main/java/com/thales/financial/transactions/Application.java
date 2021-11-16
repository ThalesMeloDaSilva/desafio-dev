package com.thales.financial.transactions;

import com.thales.financial.transactions.repository.FinancialTransactionsRepository;
import com.thales.financial.transactions.repository.FinancialTransactionsRepositoryImpl;
import com.thales.financial.transactions.service.FinancialTransactionsService;
import com.thales.financial.transactions.service.FinancialTransactionsServiceImpl;
import com.thales.financial.transactions.utils.FileParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public FinancialTransactionsRepository financialTransactionsRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return new FinancialTransactionsRepositoryImpl(namedParameterJdbcTemplate);
	}

	@Bean
	public FileParser fileParser() {
		return new FileParser();
	}

	@Bean
	public FinancialTransactionsService financialTransactionsService(FinancialTransactionsRepository financialTransactionsRepository,
																	 FileParser fileParser) {
		return new FinancialTransactionsServiceImpl(financialTransactionsRepository, fileParser);
	}

}
