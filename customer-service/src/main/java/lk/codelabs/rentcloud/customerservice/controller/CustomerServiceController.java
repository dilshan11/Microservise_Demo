package lk.codelabs.rentcloud.customerservice.controller;

import lk.codelabs.rentcloud.customerservice.service.CustomerService;
import lk.codelabs.rentcloud.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerServiceController {

        //save
        //getCustomer
        //getAllCustomer
        //update
        //delete

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable int id) {
        System.out.println("request came on "+LocalDateTime.now() + "  3  ++++++++++++++++++++++");
        return customerService.findById(id);
    }
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @PutMapping(value = "{/id}")
    public Customer update(@PathVariable("id") int id,@RequestBody Customer customer){
       return this.customerService.updateService(id,customer);
    }



}
