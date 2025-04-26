package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.CustomerRepository;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.proxy.ICustomerOperations;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final ICustomerRepository customerRepository;
  private final ICustomerOperations customerOperations;

  public CustomerService(ICustomerRepository customerRepository, ICustomerOperations customerOperations) {

    this.customerRepository = customerRepository;
    this.customerOperations=customerOperations;
  }

  public Customer create(CustomerDTO customerDTO) {
    Customer customer = Customer
      .builder()
      .name(customerDTO.getName())
      .email(customerDTO.getEmail())
      .build();

    if (customerOperations.isNotYahooEmail(customerDTO.getEmail())) {
      throw new IllegalArgumentException("No se permiten correos del dominio yahoo.com");
    }
    return customerRepository.save(customer);
  }
}
