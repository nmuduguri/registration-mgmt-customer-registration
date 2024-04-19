package com.ngalaxy.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngalaxy.registration.model.CustomerRegistration;


@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, Integer>{
	
	public CustomerRegistration findByEmail(String email);
	
	// select * from customer_repository;
	// select * from customer-registration where email = "test@gmail.com";
	
	
	// 1. Try to update addhar pdf file;
	// 2. Change h2-db to sql db

}

