package ru.lsan.htmlweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"ru.lsan.htmlweb"})
@ComponentScan
public class HtmlwebApplication {


	public static void main(String[] args){
		SpringApplication.run(HtmlwebApplication.class, args);
	}

}
