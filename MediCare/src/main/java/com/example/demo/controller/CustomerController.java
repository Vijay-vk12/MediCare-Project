package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService ser;
	
	@PostMapping("/csignup")
	ResponseEntity<Customer> customerSignUp(@RequestBody Customer c)
	{
		return new ResponseEntity<Customer>(ser.customerSignUp(c),HttpStatus.CREATED);
	}
	
	@GetMapping("/clogin")
	ResponseEntity<Customer> customerLogin(@RequestHeader String data,@RequestHeader String cpassword)
	{
		return new ResponseEntity<Customer>(ser.customerLogin(data,cpassword),HttpStatus.FOUND);
	}
	
	
	@GetMapping("/cvalidateforgot")
	ResponseEntity<Customer> customerValidate(@RequestHeader String data)
	{
		return new ResponseEntity<Customer>(ser.customervalidate(data),HttpStatus.FOUND);
	}
	
	@PutMapping("/cupdatepass")
	ResponseEntity<Customer> customerUpdatePass(@RequestHeader String data,@RequestHeader String cpassword)
	{
		return new ResponseEntity<Customer>(ser.customerUpdatePass(data,cpassword),HttpStatus.OK);
	}
	
}
