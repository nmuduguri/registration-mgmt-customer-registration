package com.ngalaxy.registration.service;

import java.util.List;

import com.ngalaxy.registration.model.CustomerRegistration;

public interface CustomerRegistrationReaderService {

	List<CustomerRegistration> getRegisteredCustomers();

	CustomerRegistration getRegisteredCustomer(Integer custId) throws IllegalArgumentException;
}
