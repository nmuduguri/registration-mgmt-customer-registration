package com.ngalaxy.registration.controller.login;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.response.CustomerRegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/login-mgmt")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<?> login() {

        return new ResponseEntity<CustomerRegistrationResponse>(HttpStatus.OK);
        //return new ResponseEntity<CustomerRegistrationResponse>(
          //      customerRegistrationWriterService.saveCustomerRegistration(customer, adharFile), HttpStatus.OK);
    }
}
