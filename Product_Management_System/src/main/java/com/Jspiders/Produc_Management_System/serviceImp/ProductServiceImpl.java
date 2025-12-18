package com.Jspiders.Produc_Management_System.serviceImp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jspiders.Produc_Management_System.Exception.ResourceNotFoundException;
import com.Jspiders.Produc_Management_System.Repository.IdGeneratorRepo;
import com.Jspiders.Produc_Management_System.Repository.OwnerRepository;
import com.Jspiders.Produc_Management_System.Repository.ProductRepository;
import com.Jspiders.Produc_Management_System.ResponseDto.ProductDto;
import com.Jspiders.Produc_Management_System.entity.IdGenerator;
import com.Jspiders.Produc_Management_System.entity.Owner;
import com.Jspiders.Produc_Management_System.entity.Product;
import com.Jspiders.Produc_Management_System.service.IProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private IdGeneratorRepo generatorRepo;

    @Autowired
    private ModelMapper modelMapper;

    private String generateProductId() {
        IdGenerator gen = generatorRepo.save(new IdGenerator());
        int id = gen.getId();
        return id <= 9 ? "PROD00" + id : id <= 99 ? "PROD0" + id : "PROD" + id;
    }

    private int calculateProductAge(LocalDate manufactureDate) {
        return Period.between(manufactureDate, LocalDate.now()).getYears();
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        if (productDto.getOwnerId() == null) {
            throw new IllegalArgumentException("Owner ID must be provided");
        }

        Owner owner = ownerRepository.findById(productDto.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found: " + productDto.getOwnerId()));

        Product product = modelMapper.map(productDto, Product.class);
        product.setPid(generateProductId());
        product.setOwner(owner);

        if (product.getDateOfManufacture() != null) {
            product.setAgeOfProduct(calculateProductAge(product.getDateOfManufacture()));
            product.setExpDate(product.getDateOfManufacture().plusYears(1));
        }

        Product saved = productRepository.save(product);
        ProductDto dto = modelMapper.map(saved, ProductDto.class);
        dto.setOwnerId(owner.getOwnerId());
        return dto;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(p -> {
            ProductDto dto = modelMapper.map(p, ProductDto.class);
            dto.setOwnerId(p.getOwner() != null ? p.getOwner().getOwnerId() : null);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(String pid) {
        Product product = productRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + pid));
        ProductDto dto = modelMapper.map(product, ProductDto.class);
        dto.setOwnerId(product.getOwner() != null ? product.getOwner().getOwnerId() : null);
        return dto;
    }

    @Override
    public ProductDto updateProduct(String pid, ProductDto productDto) {
        Product existing = productRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + pid));

        existing.setPrice(productDto.getPrice());
        existing.setCompanyName(productDto.getCompanyName());
        existing.setProductType(productDto.getProductType());
        existing.setDetails(productDto.getDetails());
        existing.setColor(productDto.getColor());

        if (productDto.getDateOfManufacture() != null) {
            existing.setDateOfManufacture(productDto.getDateOfManufacture());
            existing.setAgeOfProduct(calculateProductAge(productDto.getDateOfManufacture()));
            existing.setExpDate(productDto.getDateOfManufacture().plusYears(1));
        }

        Product updated = productRepository.save(existing);
        ProductDto dto = modelMapper.map(updated, ProductDto.class);
        dto.setOwnerId(updated.getOwner() != null ? updated.getOwner().getOwnerId() : null);
        return dto;
    }

    @Override
    public void deleteProduct(String pid) {
        Product existing = productRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + pid));
        productRepository.delete(existing);
    }

    @Override
    public List<ProductDto> getExpiredProducts() {
        return productRepository.findByExpDateBefore(LocalDate.now()).stream().map(p -> {
            ProductDto dto = modelMapper.map(p, ProductDto.class);
            dto.setOwnerId(p.getOwner() != null ? p.getOwner().getOwnerId() : null);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByOwnerId(String ownerId) {
        return productRepository.findByOwnerOwnerId(ownerId).stream().map(p -> {
            ProductDto dto = modelMapper.map(p, ProductDto.class);
            dto.setOwnerId(ownerId);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByColor(String color) {
        return productRepository.findAll().stream()
                .filter(p -> p.getColor() != null && p.getColor().stream()
                        .anyMatch(c -> c != null && c.equalsIgnoreCase(color)))
                .map(p -> {
                    ProductDto dto = modelMapper.map(p, ProductDto.class);
                    dto.setOwnerId(p.getOwner() != null ? p.getOwner().getOwnerId() : null);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProductPrice(String pid, Double newPrice) {
        Product product = productRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + pid));

        product.setPrice(newPrice);
        Product saved = productRepository.save(product);
        ProductDto dto = modelMapper.map(saved, ProductDto.class);
        dto.setOwnerId(saved.getOwner() != null ? saved.getOwner().getOwnerId() : null);
        return dto;
    }

    @Override
    public List<ProductDto> getProductsByCompanyName(String companyName) {
        return productRepository.findByCompanyName(companyName).stream().map(p -> {
            ProductDto dto = modelMapper.map(p, ProductDto.class);
            dto.setOwnerId(p.getOwner() != null ? p.getOwner().getOwnerId() : null);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByPriceRange(Double min, Double max) {
        return productRepository.findByPriceBetween(min, max).stream().map(p -> {
            ProductDto dto = modelMapper.map(p, ProductDto.class);
            dto.setOwnerId(p.getOwner() != null ? p.getOwner().getOwnerId() : null);
            return dto;
        }).collect(Collectors.toList());
    }
}
