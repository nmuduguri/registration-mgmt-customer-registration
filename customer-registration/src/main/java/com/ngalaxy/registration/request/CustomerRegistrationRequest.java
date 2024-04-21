package com.ngalaxy.registration.request;

import org.springframework.web.multipart.MultipartFile;

import com.ngalaxy.registration.model.CustomerRegistration;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustomerRegistrationRequest {

	private CustomerRegistration customerRegistration;
	private MultipartFile adharFile;
}
