package com.doubledigit.securespring.Controllers;

import com.doubledigit.securespring.Models.Product;
import com.doubledigit.securespring.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String GuestMessage() {
        return "Hello guest!";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/list")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/each/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

}
