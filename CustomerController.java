package jsp.supplychainmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Customer;
import jsp.supplychainmanagement.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerservice;

    @PostMapping
    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
        return customerservice.saveCustomer(customer);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Customer>>> getCustomer() {
        return customerservice.getCustomer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Customer>> getCustomer(@PathVariable int id) {
        return customerservice.getCustomerByid(id);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer) {
        return customerservice.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@PathVariable int id) {
        return customerservice.deleteCustomer(id);
    }
}