package com.ngalaxy.registration.service;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.repository.CustomerRegistrationRepository;
import com.ngalaxy.registration.response.CustomerRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class CustomerRegistrationWriterServiceImpl implements CustomerRegistrationWriterService {

    @Autowired
    CustomerRegistrationRepository customerRegistrationRepository;

    @Override
    public CustomerRegistrationResponse saveCustomerRegistration(CustomerRegistration customer, MultipartFile adharFile) {

        CustomerRegistration cust = null;
        CustomerRegistrationResponse validateResponse = validateAdharFile(adharFile);
        if (validateResponse != null) {
            return new CustomerRegistrationResponse("1007", "Please upload valid file :" + adharFile.getOriginalFilename());
        }

        if (customer != null && customer.getEmail() != null && !customer.getEmail().isEmpty()) {

            cust = customerRegistrationRepository.findByEmail(customer.getEmail());
        }
        if (cust == null) {
            customer.setAdharFileName(adharFile.getOriginalFilename());
            try {
                customer.setAdharFileContent(adharFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            customerRegistrationRepository.save(customer);
            return new CustomerRegistrationResponse("200", "Customer Registration Saved Successfully");
        } else {
            return new CustomerRegistrationResponse("1006", "Given Email Address already Existed :" + customer.getEmail());
        }

    }

    private CustomerRegistrationResponse validateAdharFile(MultipartFile adharFile) {
        try {
            if (adharFile == null || (adharFile != null && adharFile.getBytes() == null)) {
                return new CustomerRegistrationResponse("1007", "Please upload valid file :" + adharFile.getOriginalFilename());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public CustomerRegistrationResponse updateCustomerRegistration(CustomerRegistration userCustomerRegistration, MultipartFile adharFile) {

        CustomerRegistrationResponse response = null;
        CustomerRegistration dbCustomerRegistration = new CustomerRegistration();

        if (userCustomerRegistration != null) {
            if (userCustomerRegistration.getCustId() != null && userCustomerRegistration.getCustId() > 0) {
                Optional<CustomerRegistration> optionalObj = customerRegistrationRepository.findById(userCustomerRegistration.getCustId());

                if (optionalObj.isPresent()) {
                    dbCustomerRegistration = optionalObj.get();
                } else {
                    return new CustomerRegistrationResponse("1005", "CustomerRegistration Object Not Found for Given Customer Id");
                }
            }

            if (userCustomerRegistration.getFname() != null && !userCustomerRegistration.getFname().isEmpty()) {
                dbCustomerRegistration.setFname(userCustomerRegistration.getFname());
            }

            if (userCustomerRegistration.getLname() != null && !userCustomerRegistration.getLname().isEmpty()) {
                dbCustomerRegistration.setLname(userCustomerRegistration.getLname());
            }

            if (userCustomerRegistration.getEmail() != null && !userCustomerRegistration.getEmail().isEmpty()) {
                dbCustomerRegistration.setEmail(userCustomerRegistration.getEmail());
            }

            if (userCustomerRegistration.getMobile() != null && !userCustomerRegistration.getMobile().isEmpty()) {
                dbCustomerRegistration.setMobile(userCustomerRegistration.getMobile());
            }
            if (userCustomerRegistration.getAdharNo() != null && !userCustomerRegistration.getAdharNo().isEmpty()) {
                dbCustomerRegistration.setAdharNo(userCustomerRegistration.getAdharNo());
            }
            if (adharFile != null) {
                dbCustomerRegistration.setAdharFileName(adharFile.getOriginalFilename());
                try {
                    dbCustomerRegistration.setAdharFileContent(adharFile.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            customerRegistrationRepository.save(dbCustomerRegistration);

            response = new CustomerRegistrationResponse("200", "Customer Registration Updated Successfully");
        } else {
            response = new CustomerRegistrationResponse("1004", "CustomerRegistration Object is null");
        }
        return response;
    }

}
