package com.example.ProductManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductManagement.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers,Integer>{

}
