package com.ngalaxy.registration.controller.registration;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.response.CustomerRegistrationResponse;
import com.ngalaxy.registration.service.CustomerRegistrationReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registration-mgmt")
public class CustomerRegistrationReaderController {

    @Autowired
    CustomerRegistrationReaderService customerRegistrationReaderService;

    @GetMapping("/customer-registration/{custId}")
    public ResponseEntity<?> getRegisteredCustomers(@PathVariable("custId") Integer custId) {

        Optional<CustomerRegistration> customerRegistration = customerRegistrationReaderService.getRegisteredCustomer(custId);
        if (customerRegistration.isPresent()) {
            return new ResponseEntity<CustomerRegistration>(customerRegistration.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<CustomerRegistrationResponse>(new CustomerRegistrationResponse("9901", "No Registered Customer Found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer-registration")
    public ResponseEntity<List<CustomerRegistration>> getRegisteredCustomers() {
        return new ResponseEntity<List<CustomerRegistration>>(
                customerRegistrationReaderService.getRegisteredCustomers(), HttpStatus.OK);
    }

}
