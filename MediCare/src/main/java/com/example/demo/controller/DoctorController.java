package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
//
	//localhost:8080/swagger-ui/index.html
	@RequestMapping("/welcome api")
	String dummyController() {
		return "hello doctor";
	}
}
