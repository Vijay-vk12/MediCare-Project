package com.example.demo.module;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@Column(nullable = false,unique = true)
	private String cname;
	@Column(nullable = false)
	private long cphno;
	@Column(nullable = false)
	private String cpassword;
	@Column(nullable = false)
	private String cemail;
	@Column(nullable = false)
	private String cgender;
	@Column(nullable = false)
	private int cage;
	private String cbloodgroup;
	private double cheight;
	private double cweight;
	
	
	
}
