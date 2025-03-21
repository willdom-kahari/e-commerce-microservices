package com.waduclay.ecommerce.customer;


import com.waduclay.ecommerce.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public String createCustomer(@Valid CustomerRequest request) {
        if (request == null) {
            return null;
        }
        var pendingCustomer = Customer.of(request);
        Customer customer = customerRepository.save(pendingCustomer);
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())
                ));
        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, @Valid CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (customer.getAddress() != null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream().map(Customer::toCustomerResponse)
                .toList();
    }

    public Boolean existsCustomerById(String id) {
        return customerRepository.existsById(id);
    }

    public CustomerResponse findById(String id) {
        return customerRepository.findById(id)
                .map(Customer::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("No customer found with the provided ID:: %s", id)
                ));
    }

    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }
}
