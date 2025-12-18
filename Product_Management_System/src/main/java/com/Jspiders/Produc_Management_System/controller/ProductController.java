package com.Jspiders.Produc_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Jspiders.Produc_Management_System.ResponseDto.ProductDto;
import com.Jspiders.Produc_Management_System.service.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto created = productService.createProduct(productDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String pid) {
        ProductDto product = productService.getProductById(pid);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String pid, @RequestBody ProductDto productDto) {
        ProductDto updated = productService.updateProduct(pid, productDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable String pid) {
        productService.deleteProduct(pid);
        return ResponseEntity.ok("Product deleted successfully!");
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<ProductDto>> getProductsByOwner(@PathVariable String ownerId) {
        List<ProductDto> products = productService.getProductsByOwnerId(ownerId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<ProductDto>> getProductByColor(@PathVariable String color) {
        List<ProductDto> products = productService.getProductsByColor(color);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{pid}/price/{newPrice}")
    public ResponseEntity<ProductDto> updateProductPrice(@PathVariable String pid, @PathVariable Double newPrice) {
        ProductDto updated = productService.updateProductPrice(pid, newPrice);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/company/{companyName}")
    public ResponseEntity<List<ProductDto>> getProductByCompany(@PathVariable String companyName) {
        List<ProductDto> products = productService.getProductsByCompanyName(companyName);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/expired")
    public ResponseEntity<List<ProductDto>> getExpiredProducts() {
        List<ProductDto> products = productService.getExpiredProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ProductDto>> getProductsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        List<ProductDto> products = productService.getProductsByPriceRange(min, max);
        return ResponseEntity.ok(products);
    }
}
