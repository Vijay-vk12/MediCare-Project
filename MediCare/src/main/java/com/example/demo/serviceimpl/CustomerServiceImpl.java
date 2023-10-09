package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidCredentialSException;
import com.example.demo.module.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo repo;
     
     BCryptPasswordEncoder b1=new BCryptPasswordEncoder();
	
	
	@Override
	public Customer customerSignUp(Customer c) {
		
		String usn=repo.findByUsername(c.getCname());
		String c1=c.getCphno()+"";
		if(usn!=null)
		{
			throw new InvalidCredentialSException("Username Already exists");
		}
		
		
		if((c.getCpassword()!=null && c.getCpassword().length()>=8))
		{
			c.setCpassword(b1.encode(c.getCpassword()));
			if(c1.charAt(0)>='6' &&c1.charAt(0)<='9'&& c1.length()==10)
				
			{
				return repo.save(c);	
			}
			
			else
			{
				throw new InvalidCredentialSException("Invalid Phone Number");
			}
			
			
		}
		else
		{
			throw new InvalidCredentialSException("Invalid Password Length should be More than 8 ");
		}
		
	}


	@Override
	public Customer customerLogin(String data, String cpassword) {
		Customer c=repo.validate(data, data);
		if(c!=null)
		{
			if(b1.matches(cpassword, c.getCpassword())) {
				
				return c;
			}
			else
			{
				
				
				throw new InvalidCredentialSException("Invalid Credentials ");
			}
		}
		else
		{
			
			throw new InvalidCredentialSException("Invalid Credentials");
		}
	}


	@Override
	public Customer customervalidate(String data) {
		Customer c=repo.validate(data, data);
		if(c!=null)
		{
               return c;
		}
		else
		{
			throw new InvalidCredentialSException("Invalid User name or email");
		}
	}


	@Override
	public Customer customerUpdatePass(String data, String cpassword) {
		Customer c=repo.validate(data, data);
		if(c!=null)
		{
			cpassword=b1.encode(cpassword);
			c.setCpassword(cpassword);
			repo.save(c);
			return c;
		}
		else
		{
			throw new InvalidCredentialSException("Enter valid password");
		}
	}


}
