package jsp.supplychainmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.supplychainmanagement.dao.CustomerDAO;
import jsp.supplychainmanagement.dao.OrderDAO;
import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Customer;
import jsp.supplychainmanagement.entity.Orders;
import jsp.supplychainmanagement.exception.OrderIdNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderDAO ordersdao;
	@Autowired
	private CustomerDAO customerdao;

	public ResponseEntity<ResponseStructure<Orders>> saveOrders(Orders orders,int id)
	{
		Optional<Customer> opt= customerdao.getCustomerByid(id);
		ResponseStructure<Orders> structure=new ResponseStructure<Orders>();
		if(opt.isPresent())
		{
		Customer customer=opt.get();	
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("sucess");
		Orders receivedorder=ordersdao.saveorders(orders, customer);
		structure.setData(receivedorder);
		}
		else {
			throw new OrderIdNotFoundException();
		}
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrders()
	{
		List<Orders> l=ordersdao.getorders();
		ResponseStructure<List<Orders>> structure=new ResponseStructure<List<Orders>>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("fetched sucess");
		structure.setData(l);
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Orders>> getOdersByid(@PathVariable int id)
	{
	Optional<Orders>	opt=ordersdao.getordersByid(id);
	ResponseStructure<Orders> structure=new ResponseStructure<Orders>();
	structure.setStatusCode(HttpStatus.FOUND.value());
	structure.setMessage("Fetched By id sucess");
	if(opt.isPresent())
	{
	  structure.setData(opt.get());
	}
	else {
		throw new OrderIdNotFoundException();
	}
	return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(Orders orders)
	{
		Orders o=ordersdao.updateOrders(orders);
		ResponseStructure<Orders> structure=new ResponseStructure<Orders>();
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("update orders sucess");
		structure.setData(o);
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<Orders>> deleteOders(@PathVariable int id)
	{
	Orders orders=ordersdao.deleteOrders(id);
	ResponseStructure<Orders> structure=new ResponseStructure<Orders>();
	structure.setStatusCode(HttpStatus.FOUND.value());
	structure.setMessage("deleted By id sucess");
	  structure.setData(orders);

	return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<List<Orders>>> findOrdersByCustomerId(int id) {
		
		List<Orders> orders=ordersdao.findOrdersByCustomerId(id);
		ResponseStructure<List<Orders>> structure=new ResponseStructure<List<Orders>>();
		structure.setStatusCode(id);
		structure.setMessage("order sucess");
		structure.setData(orders);
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure,HttpStatus.ACCEPTED);
		
		
	}
	public ResponseEntity<ResponseStructure<Orders>> findOrdersByTrackingnumber(String trackingNumber)
	{
	  Optional<Orders> opt=	ordersdao.findOrdersByTrackingnumber(trackingNumber);
	  ResponseStructure<Orders> structure=new ResponseStructure<Orders>();
	  if(opt.isPresent())
	  {
	  structure.setStatusCode(HttpStatus.FOUND.value());
	  structure.setMessage("fetched sucess");
	  structure.setData(opt.get());
	  return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.FOUND);
	  }
	  else {
		  structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	      structure.setMessage("Order not found");
	      structure.setData(null);
 
	  return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.NOT_FOUND);
	}
	}
}
