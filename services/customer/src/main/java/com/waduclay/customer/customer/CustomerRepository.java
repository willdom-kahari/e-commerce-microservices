package com.waduclay.customer.customer;


import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
