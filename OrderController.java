package jsp.supplychainmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Orders;
import jsp.supplychainmanagement.service.OrderService;
@RequestMapping("/api/orders")
@RestController
public class OrderController {
@Autowired
private OrderService orderservice;
@PostMapping("/{id}")
public ResponseEntity<ResponseStructure<Orders>> saveOrders(@RequestBody Orders orders,@PathVariable int id)
{
	return orderservice.saveOrders(orders,id);
	
	
}
@GetMapping
public ResponseEntity<ResponseStructure<List<Orders>>> getOrders()
{
	return orderservice.getOrders();
}
@GetMapping("/{id}")
public ResponseEntity<ResponseStructure<Orders>> getordersByid(@PathVariable int id)
{
	return orderservice.getOdersByid(id);
}
@GetMapping("/c/{cid}")
public ResponseEntity<ResponseStructure<List<Orders>>> findOrdersByCustomerId(@PathVariable int cid)
{
	return orderservice.findOrdersByCustomerId(cid);
}
@PutMapping
public ResponseEntity<ResponseStructure<Orders>> updateOrders(@RequestBody Orders orders)
{
	return orderservice.updateOrders(orders);
}
@DeleteMapping("/{id}")
public ResponseEntity<ResponseStructure<Orders>> deleteOrders(@PathVariable int id)
{
	return orderservice.deleteOders(id);
}
@GetMapping("/s/{trackingNumber}")
public ResponseEntity<ResponseStructure<Orders>> findOrdersByTrackingnumber(@PathVariable String trackingNumber)
{
	return orderservice.findOrdersByTrackingnumber(trackingNumber);
}

}

