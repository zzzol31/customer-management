package com.customermanagement.customer.management.Repository;

import com.customermanagement.customer.management.Document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<Customer, String> {
}
