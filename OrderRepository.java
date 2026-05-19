package jsp.supplychainmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.supplychainmanagement.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

	@Query("select o from Orders o where o.customer.id=?1" )
	List<Orders> findOrdersByCustomerId(int id);
	
	@Query("select o from Orders o where o.trackingNumber=?1")
	Optional<Orders> findOrdersByTrackingnumber(String trackingNumber);

}
