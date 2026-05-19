package jsp.supplychainmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jsp.supplychainmanagement.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException( ProductIdNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("not found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SupplierIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException1( SupplierIdNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("not found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	} 
	@ExceptionHandler(OrderIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException2(OrderIdNotFoundException  exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("not found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	} 
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException3(CustomerIdNotFoundException  exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("not found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
