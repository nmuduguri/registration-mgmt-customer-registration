package com.ngalaxy.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngalaxy.registration.model.CustomerRegistration;
import com.ngalaxy.registration.repository.CustomerRegistrationRepository;
import com.ngalaxy.registration.response.CustomerRegistrationResponse;

@Service
public class CustomerRegistrationService {
	@Autowired
	CustomerRegistrationRepository customerRegistrationRepository;

	public CustomerRegistrationResponse saveCustomerRegistration(CustomerRegistration customer) {

		CustomerRegistration cust = null;
		if (customer != null && customer.getEmail() != null && !customer.getEmail().isEmpty()) {

			cust = customerRegistrationRepository.findByEmail(customer.getEmail());
		}
		if (cust == null) {
			customerRegistrationRepository.save(customer);
			return new CustomerRegistrationResponse("200", "Customer Registration Saved Successfully");
		} else {
			return new CustomerRegistrationResponse("1006",
					"Given Email Address already Existed :" + customer.getEmail());
		}

	}

	public List<CustomerRegistration> getRegisteredCustomers() {
		return customerRegistrationRepository.findAll();
	}

	public CustomerRegistration getRegisteredCustomer(Integer custId) throws IllegalArgumentException {

		CustomerRegistration customerRegistration = null;
		if (custId != null && custId > 0) {
			customerRegistration = customerRegistrationRepository.findById(custId).get();
		} else {
			throw new IllegalArgumentException("Please Provide Valid Customer Id");
		}
		return customerRegistration;
	}

	public CustomerRegistrationResponse updateCustomerRegistration(CustomerRegistration userCustomerRegistration) {

		CustomerRegistrationResponse response = null;
		CustomerRegistration dbCustomerRegistration = new CustomerRegistration();

		if (userCustomerRegistration != null) {
			if (userCustomerRegistration.getCustId() != null && userCustomerRegistration.getCustId() > 0) {
				Optional<CustomerRegistration> optionalObj = customerRegistrationRepository
						.findById(userCustomerRegistration.getCustId());

				if (optionalObj.isPresent()) {
					dbCustomerRegistration = optionalObj.get();
				} else {
					return new CustomerRegistrationResponse("1005",
							"CustomerRegistration Object Not Found for Given Customer Id");
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

			if (userCustomerRegistration.getPinCode() != null && !userCustomerRegistration.getPinCode().isEmpty()) {
				dbCustomerRegistration.setPinCode(userCustomerRegistration.getPinCode());
			}

			if (userCustomerRegistration.getCity() != null && !userCustomerRegistration.getCity().isEmpty()) {
				dbCustomerRegistration.setCity(userCustomerRegistration.getCity());
			}

			if (userCustomerRegistration.getAdharNo() != null && !userCustomerRegistration.getAdharNo().isEmpty()) {
				dbCustomerRegistration.setAdharNo(userCustomerRegistration.getAdharNo());
			}

			if (userCustomerRegistration.getAdharFile() != null && !userCustomerRegistration.getAdharFile().isEmpty()) {
				dbCustomerRegistration.setAdharFile(userCustomerRegistration.getAdharFile());
			}
			customerRegistrationRepository.save(dbCustomerRegistration);

			response = new CustomerRegistrationResponse("200", "Customer Registration Updated Successfully");
		} else {
			response = new CustomerRegistrationResponse("1004", "CustomerRegistration Object is null");
		}
		return response;
	}

}
