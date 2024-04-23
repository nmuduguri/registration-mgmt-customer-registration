package com.ngalaxy.registration.service;

import org.springframework.web.multipart.MultipartFile;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.response.CustomerRegistrationResponse;

public interface CustomerRegistrationWriterService {
	
	CustomerRegistrationResponse saveCustomerRegistration(CustomerRegistration customer, MultipartFile adharFile);

	CustomerRegistrationResponse updateCustomerRegistration(CustomerRegistration userCustomerRegistration, MultipartFile adharFile);
}
