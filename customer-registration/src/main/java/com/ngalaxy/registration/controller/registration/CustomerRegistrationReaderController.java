package com.ngalaxy.registration.controller.registration;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.service.CustomerRegistrationReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/registration-mgmt")
public class CustomerRegistrationReaderController {

	@Autowired
	CustomerRegistrationReaderService customerRegistrationReaderService;

	@GetMapping("/customer-registration/{custId}")
	public ResponseEntity<CustomerRegistration> getRegisteredCustomers(Integer custId) {
		return new ResponseEntity<CustomerRegistration>(
				customerRegistrationReaderService.getRegisteredCustomer(custId), HttpStatus.OK);
	}

	@GetMapping("/customer-registration")
	public ResponseEntity<List<CustomerRegistration>> getRegisteredCustomers() {
		return new ResponseEntity<List<CustomerRegistration>>(
				customerRegistrationReaderService.getRegisteredCustomers(), HttpStatus.OK);
	}

}
