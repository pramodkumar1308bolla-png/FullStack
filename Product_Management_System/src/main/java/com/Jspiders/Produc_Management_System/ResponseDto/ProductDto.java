package com.Jspiders.Produc_Management_System.ResponseDto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private String pid;
    private Double price;
    private String companyName;
    private LocalDate dateOfManufacture;
    private String productType;
    private LocalDate expDate;
    private Integer ageOfProduct;
    private String details;
    private List<String> color;
    private String ownerId;
}
