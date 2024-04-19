package com.ngalaxy.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.response.CustomerRegistrationResponse;
import com.ngalaxy.registration.service.CustomerRegistrationService;

@RestController
@RequestMapping("/api/registration-mgmt")
public class CustomerRegistrationController {
	@Autowired
	CustomerRegistrationService customerRegistrationService;

	@PostMapping("/customer-registration")
	public ResponseEntity<CustomerRegistrationResponse> saveCustomerRegistration(@RequestBody CustomerRegistration customer) {
		return new ResponseEntity<CustomerRegistrationResponse>(
				customerRegistrationService.saveCustomerRegistration(customer), HttpStatus.OK);
	}

	@GetMapping("/customer-registration")
	public ResponseEntity<List<CustomerRegistration>> getRegisteredCustomers() {
		return new ResponseEntity<List<CustomerRegistration>>(customerRegistrationService.getRegisteredCustomers(),
				HttpStatus.OK);
	}

	@PutMapping("/customer-registration")
	public ResponseEntity<CustomerRegistrationResponse> updateMethod(
			@RequestBody CustomerRegistration customerRegistration) {

		return new ResponseEntity<CustomerRegistrationResponse>(
				customerRegistrationService.updateCustomerRegistration(customerRegistration), HttpStatus.OK);
	}
}
