package jsp.supplychainmanagement.exception;

public class OrderIdNotFoundException extends RuntimeException{
	public String getMessage()
	{
		return "order id not found";
	}
}
