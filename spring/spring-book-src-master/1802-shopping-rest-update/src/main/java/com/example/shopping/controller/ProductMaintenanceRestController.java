package com.example.shopping.controller;

import java.net.URI;
import java.util.List;

import com.example.shopping.exception.DataNotFoundException;
import com.example.shopping.input.ProductMaintenanceInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.shopping.entity.Product;
import com.example.shopping.service.ProductMaintenanceService;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/products")
public class ProductMaintenanceRestController {
    private final ProductMaintenanceService productMaintenanceService;

    public ProductMaintenanceRestController(ProductMaintenanceService productMaintenanceService) {
        this.productMaintenanceService = productMaintenanceService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productMaintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        Product product = productMaintenanceService.findById(id);
        if(product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return product;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable String id, @RequestBody ProductMaintenanceInput productMaintenanceInput) {
        productMaintenanceInput.setId(id);
        productMaintenanceService.update(productMaintenanceInput);
    }

    @PostMapping("/")
    public ResponseEntity<Void> registerProduct(@Validated @RequestBody ProductMaintenanceInput productMaintenanceInput) {
        Product product = productMaintenanceService.register(productMaintenanceInput);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id) {
        productMaintenanceService.delete(id);
    }

}