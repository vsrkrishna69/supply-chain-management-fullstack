package jsp.supplychainmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.supplychainmanagement.entity.Supplier;
import jsp.supplychainmanagement.exception.SupplierIdNotFoundException;
import jsp.supplychainmanagement.repository.SupplierRepository;

@Repository
public class SupplierDAO {
	@Autowired
	private SupplierRepository supplierrepositary;
	public Supplier saveSupplier(Supplier supplier)
	{
		return supplierrepositary.save(supplier);
	}
	public List<Supplier> getSupplier()
	{
		return supplierrepositary.findAll();
	}
	public Optional<Supplier> getSupplierByid(@PathVariable int id)
	{

		return supplierrepositary.findById(id);
	}
	public Supplier updateSupplier(Supplier supplier)
	{
		return supplierrepositary.save(supplier);
	}
	public Supplier deleteSupplier(int id)											
	{
		Optional<Supplier> opt= supplierrepositary.findById(id);
//		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		if(opt.isPresent())
		{

			supplierrepositary.delete(opt.get());
			return opt.get();
		}
		
		throw new SupplierIdNotFoundException();
				
	}

}
