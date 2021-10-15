package lk.codelabs.rentcloud.customerservice.service;

import lk.codelabs.rentcloud.model.customer.Customer;

import java.util.List;


public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();

    Customer updateService(int id,Customer customer);
}
