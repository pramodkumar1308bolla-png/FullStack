package com.Jspiders.Produc_Management_System.service;

import java.util.List;
import com.Jspiders.Produc_Management_System.ResponseDto.ProductDto;

public interface IProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(String pid);
    ProductDto updateProduct(String pid, ProductDto productDto);
    void deleteProduct(String pid);
    List<ProductDto> getProductsByOwnerId(String ownerId);
    List<ProductDto> getProductsByColor(String color);
    ProductDto updateProductPrice(String pid, Double newPrice);
    List<ProductDto> getProductsByCompanyName(String companyName);
    List<ProductDto> getExpiredProducts();
    List<ProductDto> getProductsByPriceRange(Double min, Double max);
}
