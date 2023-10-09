package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import  com.example.demo.module.*;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
	@Query(value="select * from Customer where cemail=?1 or cname=?2",nativeQuery=true)
	Customer validate(String cemail,String cname);
	
	@Query(value="select * from Customer where cname=?1",nativeQuery=true)
	String findByUsername(String cname);
	
	
	
	
	
	
	
	
	
}
