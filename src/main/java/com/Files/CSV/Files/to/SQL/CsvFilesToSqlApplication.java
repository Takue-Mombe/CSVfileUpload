package com.Files.CSV.Files.to.SQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.text.html.parser.Entity;

@SpringBootApplication
@EntityScan(basePackages = "com.Files.CSV.Files.to.SQL.Entity")
public class CsvFilesToSqlApplication {

	public static void main(String[] args) {

		SpringApplication.run(CsvFilesToSqlApplication.class, args);
	}

}
