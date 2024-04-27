package com.ngalaxy.registration.service;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.repository.CustomerRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerRegistrationReaderServiceImpl implements CustomerRegistrationReaderService {

    @Autowired
    CustomerRegistrationRepository customerRegistrationRepository;

    @Override
    public List<CustomerRegistration> getRegisteredCustomers() {
        return customerRegistrationRepository.findAll();
    }

    @Override
    public Optional<CustomerRegistration> getRegisteredCustomer(Integer custId) throws IllegalArgumentException {

        Optional<CustomerRegistration> customerRegistration = null;
        if (custId != null && custId > 0) {
            customerRegistration = customerRegistrationRepository.findById(custId);
        } else {
            throw new IllegalArgumentException("Please Provide Valid Customer Id");
        }
        return customerRegistration;
    }

}
