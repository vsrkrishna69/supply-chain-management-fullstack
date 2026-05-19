package jsp.supplychainmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.supplychainmanagement.dao.OrderDAO;
import jsp.supplychainmanagement.dao.ProductDAO;
import jsp.supplychainmanagement.dao.SupplierDAO;
import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Orders;
import jsp.supplychainmanagement.entity.Product;
import jsp.supplychainmanagement.entity.Supplier;
import jsp.supplychainmanagement.exception.ProductIdNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDao;
	@Autowired
	private SupplierDAO supplierdao;
	@Autowired
	private OrderDAO orderdao;
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int id,int id1)
	{
		Optional<Supplier> opt=supplierdao.getSupplierByid(id);
		 Optional<Orders> opt1=orderdao.getordersByid(id1);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		if(opt.isPresent() && opt1.isPresent())
		{
			Supplier supplier=opt.get();
			Orders order=opt1.get();
			product.setSupplier(supplier);
			product.setOrder(order);
		
		Product receivedproduct=productDao.saveProduct(product,supplier,order);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("product sucess");
		structure.setData(receivedproduct);
		
		}
		
		else {
			throw new ProductIdNotFoundException();
		}
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<List<Product>>> getProduct()
	{
		List<Product> l=productDao.getProducts();
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("sucess");
		structure.setData(l);
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.FOUND);
				
		
	}
	public ResponseEntity<ResponseStructure<Product>> getProductsByid(int id)
	{
		Optional<Product> opt=productDao.getProductsByid(id);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("sucess");
		if(opt.isPresent())
		{
		structure.setData(opt.get());
		}
		else {
			throw new ProductIdNotFoundException();
		}
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Product>> UpdateProduct(Product product)
	{
		Product receivedproduct=productDao.updateProducts(product);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("product updated sucess");
		structure.setData(receivedproduct);
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(int id)
	{
		List<Product> product=productDao.getProductBySupplierid(id);
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("product updated sucess");
		structure.setData(product);
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.ACCEPTED);
		
	}
	public ResponseEntity<ResponseStructure<Product>> deleteproduct(int id)
	{
	   Product product= productDao.deleteproduct(id);
	   ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("deleted sucess");
		structure.setData(product);
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);
	}

}
