package com.Mruruc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers/1")
public class Dao {
    private final CustomerRepository customerRepository;

    public Dao(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Read:
    @GetMapping
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            Integer age,
            String email
    ){}
    //Create:
    @PostMapping
    public void addCustomer(NewCustomerRequest request){
         Customer customer=new Customer();
         customer.setName(request.name());
         customer.setAge(request.age());
         customer.setEmail(request.email());
        customerRepository.save(customer);
    }

    //Delete:
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    //Update:
    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId")NewCustomerRequest request){
        Customer customer=new Customer();
        customer.setName(request.name());
        customer.setAge(request.age());
        customer.setEmail(request.email());
        customerRepository.save(customer);
    }
}
