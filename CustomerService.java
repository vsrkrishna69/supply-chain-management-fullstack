package jsp.supplychainmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.supplychainmanagement.dao.CustomerDAO;
import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Customer;
import jsp.supplychainmanagement.exception.CustomerIdNotFoundException;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerdao;

    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {

        Customer saved = customerdao.saveCustomer(customer);

        ResponseStructure<Customer> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Customer created successfully");
        structure.setData(saved);

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<List<Customer>>> getCustomer() {

        List<Customer> list = customerdao.getCustomer();

        ResponseStructure<List<Customer>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Customers fetched successfully");
        structure.setData(list);

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<Customer>> getCustomerByid(int id) {

        Optional<Customer> opt = customerdao.getCustomerByid(id);

        if (opt.isEmpty()) {
            throw new CustomerIdNotFoundException();
        }

        ResponseStructure<Customer> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Customer found");
        structure.setData(opt.get());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer) {

        Customer updated = customerdao.updateCustomer(customer);

        ResponseStructure<Customer> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Customer updated successfully");
        structure.setData(updated);

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {

        Customer deleted = customerdao.deleteCustomer(id);

        ResponseStructure<Customer> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Customer deleted successfully");
        structure.setData(deleted);

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
}