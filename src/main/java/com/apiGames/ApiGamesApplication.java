package com.apiGames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableCaching
@EnableSpringDataWebSupport
public class ApiGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGamesApplication.class, args);
	}
	@RequestMapping
	@ResponseBody
	public String home(){
		return "ApiGames";
	}
}
