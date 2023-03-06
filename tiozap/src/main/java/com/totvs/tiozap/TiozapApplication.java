package com.totvs.tiozap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication
public class TiozapApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiozapApplication.class, args);
	}

}

@RestController
class TiozapControllers {

	@GetMapping("/hello")
	public String dizereHello() {
		return "Hello Kitty";
	}

	@GetMapping("/data")
	public LocalDate mostrarData() {
		return LocalDate.now();
	}
}
