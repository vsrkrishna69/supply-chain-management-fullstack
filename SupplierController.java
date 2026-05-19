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
import jsp.supplychainmanagement.entity.Supplier;
import jsp.supplychainmanagement.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
@Autowired

private SupplierService supplierservice;
@PostMapping
public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(@RequestBody Supplier supplier)
{
	return supplierservice.savesupplier(supplier);
}
@GetMapping()
public ResponseEntity<ResponseStructure<List<Supplier>>> getsuppliers()

{
	return supplierservice.getSupplier();
	
}
@GetMapping("/{id}")
public ResponseEntity<ResponseStructure<Supplier>> getSupplierByid(@PathVariable int id)
{
	return supplierservice.getSupplierByid(id);
}
@PutMapping
public ResponseEntity<ResponseStructure<Supplier>> upadteSupplier(@RequestBody Supplier supplier)
{
	return supplierservice.updateSupplier(supplier);
}
@DeleteMapping("/{id}")
public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(@PathVariable int id)
{
	return supplierservice.deleteSupplier(id);
}
}
