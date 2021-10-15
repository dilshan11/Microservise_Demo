package lk.codelabs.rentcloud.customerservice.service;
import lk.codelabs.rentcloud.customerservice.repository.CustomerRepository;
import lk.codelabs.rentcloud.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    int i=0;
    @Override
    public Customer findById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        i=i+1;
        System.out.println(i);
        System.out.println("one customer is executing");
        try
        {
            Thread.sleep(1000); //This will make the thread(Thread2) sleep for 3000ms.

        }
        catch(InterruptedException e)
        {
            System.out.println("Thread is interrupted - " + e);
        }


        if (customer.isPresent())
            return customer.get();
        else
            return new Customer();

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer updateService(int customerId, Customer customer){
       Optional<Customer> customerOpt=this.customerRepository.findById(customerId);
       if(customerOpt.isPresent()){
           Customer customerGot=customerOpt.get();
           customerGot.setFirstName(customer.getFirstName());
           return this.customerRepository.save(customerGot);
       }else {
           return new Customer();
       }

    }
}
