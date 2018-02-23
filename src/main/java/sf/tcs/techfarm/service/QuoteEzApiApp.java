package sf.tcs.techfarm.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class QuoteEzApiApp {
	public static void main(String []args) {
		SpringApplication.run(QuoteEzApiApp.class, args);
	}
}
