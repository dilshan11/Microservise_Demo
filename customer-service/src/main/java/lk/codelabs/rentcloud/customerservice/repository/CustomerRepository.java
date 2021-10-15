package lk.codelabs.rentcloud.customerservice.repository;

import lk.codelabs.rentcloud.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
