package com.example.demo.service;

import com.example.demo.module.Customer;

public interface CustomerService {


	Customer customerSignUp(Customer c);
	Customer customerLogin(String data,String cpassword);
	
	Customer customervalidate(String data);
	Customer customerUpdatePass(String data, String cpassword);
}

