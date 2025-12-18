package com.Jspiders.Produc_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Jspiders.Produc_Management_System.ResponseDto.OwnerDto;
import com.Jspiders.Produc_Management_System.service.IOwnerService;

@RestController
@RequestMapping("owners")
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerDto ownerDto) {
        OwnerDto createdOwner = ownerService.createOwner(ownerDto);
        return ResponseEntity.ok(createdOwner);
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<OwnerDto> owners = ownerService.getAllOwners();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable String ownerId) {
        OwnerDto owner = ownerService.getOwnerById(ownerId);
        return ResponseEntity.ok(owner);
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<OwnerDto> updateOwner(@PathVariable String ownerId, @RequestBody OwnerDto ownerDto) {
        OwnerDto updatedOwner = ownerService.updateOwner(ownerId, ownerDto);
        return ResponseEntity.ok(updatedOwner);
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<String> deleteOwner(@PathVariable String ownerId) {
        ownerService.deleteOwner(ownerId);
        return ResponseEntity.ok("Owner deleted successfully!");
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<OwnerDto> getOwnerByEmail(@PathVariable String email) {
        OwnerDto owner = ownerService.getOwnerByEmail(email);
        return ResponseEntity.ok(owner);
    }

    @GetMapping("/phno/{phno}")
    public ResponseEntity<OwnerDto> getOwnerByPhno(@PathVariable String phno) {
        OwnerDto owner = ownerService.getOwnerByPhno(phno);
        return ResponseEntity.ok(owner);
    }

    
    @PostMapping("/all")
    public ResponseEntity<OwnerDto> createOwnerWithProducts(@RequestBody OwnerDto ownerDto) {
        OwnerDto saved = ownerService.createOwnerWithProducts(ownerDto);
        return ResponseEntity.ok(saved);
    }
}
