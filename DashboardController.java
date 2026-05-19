package jsp.supplychainmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {


	@GetMapping("/dashboard")
	public String dashboard() {
	    return "dashboard";
	}

    @GetMapping("/customers-ui")
    public String customers() {
        return "customers";
    }

    @GetMapping("/products-ui")
    public String products() {
        return "products";
    }

    @GetMapping("/orders-ui")
    public String orders() {
        return "orders";
    }

    @GetMapping("/suppliers-ui")
    public String suppliers() {
        return "suppliers";
    }
}