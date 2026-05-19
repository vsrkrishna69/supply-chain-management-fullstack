package jsp.supplychainmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.supplychainmanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
