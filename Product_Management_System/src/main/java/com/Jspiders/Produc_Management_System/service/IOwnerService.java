package com.Jspiders.Produc_Management_System.service;

import java.util.List;

import com.Jspiders.Produc_Management_System.ResponseDto.OwnerDto;

public interface IOwnerService {
    OwnerDto createOwner(OwnerDto ownerDto);
    List<OwnerDto> getAllOwners();
    OwnerDto getOwnerById(String ownerId);
    OwnerDto updateOwner(String ownerId, OwnerDto ownerDto);
    void deleteOwner(String ownerId);
    OwnerDto getOwnerByEmail(String email);
    OwnerDto getOwnerByPhno(String phno);
	OwnerDto createOwnerWithProducts(OwnerDto ownerDto);
}
