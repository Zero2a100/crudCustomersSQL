package com.End2End.crudCustomersSQL.repository;

import com.End2End.crudCustomersSQL.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
