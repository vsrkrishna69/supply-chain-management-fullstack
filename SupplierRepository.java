package jsp.supplychainmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.supplychainmanagement.entity.Supplier;

public interface SupplierRepository  extends JpaRepository<Supplier, Integer>{

}
