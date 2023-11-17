package com.example.ProductManagement.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ProductManagement.model.Customers;
import com.example.ProductManagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Component
@Service
public class Customerimplementation {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customers> getCustomers(){
		return customerRepository.findAll();
	}
	
	public void saveCustomers(Customers customers ) {
		customerRepository.save(customers);
	}
	
	public void deleteCustomerById(Integer id) {
		customerRepository.deleteById(id);
	}
	
	public Customers getCustomer(Integer id) {
		return customerRepository.findById(id).get();
	}
}
