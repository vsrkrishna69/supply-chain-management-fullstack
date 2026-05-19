package jsp.supplychainmanagement.exception;

public class CustomerIdNotFoundException extends RuntimeException{
public String getMessage()
{
	return "customer id not found";
}
}
