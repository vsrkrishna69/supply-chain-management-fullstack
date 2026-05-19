package jsp.supplychainmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.supplychainmanagement.entity.Customer;
import jsp.supplychainmanagement.entity.Orders;
import jsp.supplychainmanagement.exception.OrderIdNotFoundException;
import jsp.supplychainmanagement.repository.CustomerRepository;
import jsp.supplychainmanagement.repository.OrderRepository;

@Repository
public class OrderDAO {
	@Autowired
	private OrderRepository orderrepositary;
	@Autowired
	private CustomerRepository customerrepositary;
	public Orders saveorders(Orders orders,Customer customer)

	{
		orders.setCustomer(customer);
		return orderrepositary.save(orders);
	}
	public List<Orders> getorders()
	{
		return orderrepositary.findAll();
	}
	public Optional<Orders> getordersByid(@PathVariable int id)
	{
		return orderrepositary.findById(id);
	}
	public Orders updateOrders(Orders orders)
	{
		return orderrepositary.save(orders);
	}
	public List<Orders> findOrdersByCustomerId(int id)
	{
		return orderrepositary.findOrdersByCustomerId(id);
	}
	public Optional<Orders> findOrdersByTrackingnumber(String trackingNumber)
	{
		return orderrepositary.findOrdersByTrackingnumber(trackingNumber);
	}
	public Orders  deleteOrders(int id)
	{
		Optional<Orders> opt=orderrepositary.findById(id);
		if(opt.isPresent())
		{
			orderrepositary.delete(opt.get());
			return opt.get();
		}
		else {
			throw new OrderIdNotFoundException();
		}
	}

}
