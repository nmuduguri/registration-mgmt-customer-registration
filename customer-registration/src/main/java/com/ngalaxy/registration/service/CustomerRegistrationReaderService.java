package com.ngalaxy.registration.service;

import java.util.List;
import java.util.Optional;

import com.ngalaxy.registration.model.CustomerRegistration;

public interface CustomerRegistrationReaderService {

	List<CustomerRegistration> getRegisteredCustomers();

	Optional<CustomerRegistration> getRegisteredCustomer(Integer custId) throws IllegalArgumentException;
}
