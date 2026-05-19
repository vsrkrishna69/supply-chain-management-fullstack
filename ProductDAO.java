package jsp.supplychainmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.supplychainmanagement.entity.Orders;
import jsp.supplychainmanagement.entity.Product;
import jsp.supplychainmanagement.entity.Supplier;
import jsp.supplychainmanagement.exception.ProductIdNotFoundException;
import jsp.supplychainmanagement.repository.OrderRepository;
import jsp.supplychainmanagement.repository.ProductRepository;
import jsp.supplychainmanagement.repository.SupplierRepository;

@Repository
public class ProductDAO {
	@Autowired
	private ProductRepository productrepositary;
	@Autowired
	private SupplierRepository supplierrepositary;
	@Autowired
	private OrderRepository orderrepositary;
	public Product saveProduct(Product product,Supplier supplier,Orders orders)
	{
	    product.setOrder(orders);
		product.setSupplier(supplier);;
		return productrepositary.save(product);
	}
		


	public List<Product> getProducts()
	{
		return productrepositary.findAll();
	}
	public Optional<Product> getProductsByid(int id)
	{
		return productrepositary.findById(id);
	}
	public Product updateProducts(Product product)
	{
		return productrepositary.save(product);
	}
	public List<Product> getProductBySupplierid(int id)
	{
	  
		List<Product> list=productrepositary.getProductBySupplierId(id);
		return list;
		
	}
	public Product deleteproduct(int id)
	{
		Optional<Product> opt=productrepositary.findById(id);
		if(opt.isPresent())
		{
		productrepositary.delete(opt.get());
		return opt.get();
		}
		else {
			throw new ProductIdNotFoundException();
		}
	}

}
