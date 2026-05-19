package jsp.supplychainmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/customers")
    public String customers() {
        return "customer";
    }

    @GetMapping("/products")
    public String products() {
        return "product";
    }

    @GetMapping("/orders")
    public String orders() {
        return "order";
    }

    @GetMapping("/suppliers")
    public String suppliers() {
        return "supplier";
    }
}
