package com.palessan.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

//Expose / so that it will return hello world
	
	@Value("${my.own.prop}")
	String ownProperty="";
	
	@GetMapping("/")
	public String sayHello() {
		return ownProperty+" Hello World! Time on the local server is "+ LocalDateTime.now();
	}
	@GetMapping("/test1")
	public String sayHello1() {
		return ownProperty+" Hello World1! Time on the local server is "+ LocalDateTime.now();
	}

}

