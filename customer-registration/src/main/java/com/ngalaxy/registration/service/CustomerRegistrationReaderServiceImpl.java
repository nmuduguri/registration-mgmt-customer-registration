package com.ngalaxy.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.repository.CustomerRegistrationRepository;

@Service
public class CustomerRegistrationReaderServiceImpl implements CustomerRegistrationReaderService {

	@Autowired
	CustomerRegistrationRepository customerRegistrationRepository;

	@Override
	public List<CustomerRegistration> getRegisteredCustomers() {
		return customerRegistrationRepository.findAll();
	}

	@Override
	public CustomerRegistration getRegisteredCustomer(Integer custId) throws IllegalArgumentException {

		CustomerRegistration customerRegistration = null;
		if (custId != null && custId > 0) {
			customerRegistration = customerRegistrationRepository.findById(custId).get();
		} else {
			throw new IllegalArgumentException("Please Provide Valid Customer Id");
		}
		return customerRegistration;
	}

}
