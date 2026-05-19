package jsp.supplychainmanagement.exception;

public class ProductIdNotFoundException extends RuntimeException{
	public String getMessage()
	{
		return "product id not found";
	}
}
