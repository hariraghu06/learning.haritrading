package com.example.learning.haritrading.repository;

import com.example.learning.haritrading.model.CustomerDetails;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerDetails, Long> {
}
