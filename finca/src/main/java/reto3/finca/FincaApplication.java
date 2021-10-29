package reto3.finca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
@SpringBootApplication
@EnableAutoConfiguration
public class FincaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FincaApplication.class, args);
	}

}
