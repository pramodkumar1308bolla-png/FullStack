package com.Jspiders.Produc_Management_System.ResponseDto;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerDto {
    private String ownerId;
    private String name;
    private String phno;
    private String email;
    private Integer age;
    private AddressDto address;
    private List<ProductDto> products;
    private String password;
}
