package com.Jspiders.Produc_Management_System.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    private Long addressId;
    private String streetName;
    private String city;
    private String pincode;
}
