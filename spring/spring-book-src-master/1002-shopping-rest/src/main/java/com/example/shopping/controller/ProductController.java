package com.example.shopping.controller;

import com.example.shopping.entity.Product;
import com.example.shopping.service.ProductMaintenanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductMaintenanceService productMaintenanceService;

    public ProductController(ProductMaintenanceService productMaintenanceService) {
        this.productMaintenanceService = productMaintenanceService;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productMaintenanceService.findAll();
    }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productMaintenanceService.findById(id);
    }
}
