package jsp.supplychainmanagement.exception;

public class SupplierIdNotFoundException extends RuntimeException{
	public String getMessage()
	{
		return "supplier id not found";
	}
}
