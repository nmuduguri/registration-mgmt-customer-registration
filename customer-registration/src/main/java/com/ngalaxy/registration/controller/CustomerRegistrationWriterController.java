package com.ngalaxy.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.response.CustomerRegistrationResponse;
import com.ngalaxy.registration.service.CustomerRegistrationWriterService;

@RestController
@RequestMapping("/api/registration-mgmt")
public class CustomerRegistrationWriterController {
	@Autowired
	CustomerRegistrationWriterService customerRegistrationWriterService;

	@PostMapping("/customer-registration")
	public ResponseEntity<CustomerRegistrationResponse> saveCustomerRegistration(
			@ModelAttribute("customer") CustomerRegistration customer,
			@RequestParam("adharFile") MultipartFile adharFile) {
		return new ResponseEntity<CustomerRegistrationResponse>(
				customerRegistrationWriterService.saveCustomerRegistration(customer, adharFile), HttpStatus.OK);
	}

	@PutMapping("/customer-registration")
	public ResponseEntity<CustomerRegistrationResponse> updateMethod(
			@ModelAttribute("customer") CustomerRegistration customerRegistration,
			@RequestParam("adharFile") MultipartFile adharFile) {

		return new ResponseEntity<CustomerRegistrationResponse>(
				customerRegistrationWriterService.updateCustomerRegistration(customerRegistration, adharFile),
				HttpStatus.OK);
	}
}
