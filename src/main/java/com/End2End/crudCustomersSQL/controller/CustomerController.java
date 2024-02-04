package com.End2End.crudCustomersSQL.controller;

import com.End2End.crudCustomersSQL.model.Customer;
import com.End2End.crudCustomersSQL.service.CustomerService;
import com.End2End.crudCustomersSQL.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> list(){
        List<Customer> list = customerService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        Customer customer = customerService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id:" + id));
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {return customerService.save(customer); }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails){
        Customer customer = customerService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id" + id));

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setCity(customerDetails.getCity());
        customer.setSsn(customerDetails.getSsn());

        Customer update = customerService.save(customer);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id){
        Customer customer = customerService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id :" + id));

        customerService.delete(customer.getId());
        return ResponseEntity.ok("Removed");
    }
}




