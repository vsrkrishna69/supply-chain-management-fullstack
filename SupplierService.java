package jsp.supplychainmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.supplychainmanagement.dao.SupplierDAO;
import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Supplier;
import jsp.supplychainmanagement.exception.SupplierIdNotFoundException;
import jsp.supplychainmanagement.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierDAO supplierdao;
		
		public ResponseEntity<ResponseStructure<Supplier>> savesupplier(Supplier supplier)
		{
			Supplier receivedsupplier=supplierdao.saveSupplier(supplier);
			ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("supplier sucess");
			structure.setData(receivedsupplier);
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		}
		public ResponseEntity<ResponseStructure<List<Supplier>>> getSupplier()
		{
		   List<Supplier> l=supplierdao.getSupplier();
		   ResponseStructure<List<Supplier>> structure=new ResponseStructure<List<Supplier>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("supplier sucess");
			structure.setData(l);
			return new ResponseEntity<ResponseStructure<List<Supplier>>>(structure,HttpStatus.CREATED);
		   
		}
		public ResponseEntity<ResponseStructure<Supplier>> getSupplierByid(@PathVariable int id)
		{
			Optional<Supplier> opt=supplierdao.getSupplierByid(id);
			ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("element fetched sucess");
			if(opt.isPresent())
			{
			structure.setData(opt.get());
			}
			else
			{
			  throw new SupplierIdNotFoundException();
			}
			
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		}
		public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier)
		{
			supplierdao.updateSupplier(supplier);
			 ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("supplier sucess");
				structure.setData(supplier);
				return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
			   
			
		}
		public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(@PathVariable int id)
		{
			Supplier supplier=supplierdao.deleteSupplier(id);
			ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("element fetched sucess");
			structure.setData(supplier);
	
			
		
			
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		}

}