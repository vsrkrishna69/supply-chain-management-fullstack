package jsp.supplychainmanagement.controller;

import java.util.List;

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
import jsp.supplychainmanagement.entity.Product;
import jsp.supplychainmanagement.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
private	 ProductService productservice;
@PostMapping("/{supplyid}/{orderid}")
public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable int supplyid,@PathVariable int orderid)
{
	return productservice.saveProduct(product,supplyid,orderid);
}
@GetMapping
public ResponseEntity<ResponseStructure<List<Product>>> getProducts()
{
	return productservice.getProduct();
}
@GetMapping("/{id}")
public ResponseEntity<ResponseStructure<Product>> getProductsByid(@PathVariable int id)
{
	return productservice.getProductsByid(id);
}
@PutMapping
public ResponseEntity<ResponseStructure<Product>> updateProducts(@RequestBody Product product)
{
	return productservice.UpdateProduct(product);
	
}
@GetMapping("/s/{id}")
public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(@PathVariable int id)
{
	return productservice.getProductBySupplierId(id);
}

@DeleteMapping("/{id}")
public ResponseEntity<ResponseStructure<Product>> deleteproduct(@PathVariable int id)
{
	return productservice.deleteproduct(id);
}


}