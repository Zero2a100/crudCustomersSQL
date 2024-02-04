package com.End2End.crudCustomersSQL.service;

import com.End2End.crudCustomersSQL.model.Customer;
import com.End2End.crudCustomersSQL.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> list() { return customerRepository.findAll();}

    public Customer save(Customer customer) { return  customerRepository.save(customer);}

    public Optional<Customer> findById(Integer id)  { return customerRepository.findById(id);}

    public void delete (int id){ customerRepository.deleteById(id);}

}
