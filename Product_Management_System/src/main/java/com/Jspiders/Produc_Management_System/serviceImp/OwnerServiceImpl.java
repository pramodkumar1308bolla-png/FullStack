package com.Jspiders.Produc_Management_System.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Jspiders.Produc_Management_System.Exception.ResourceNotFoundException;
import com.Jspiders.Produc_Management_System.Repository.IdGeneratorRepo;
import com.Jspiders.Produc_Management_System.Repository.OwnerRepository;
import com.Jspiders.Produc_Management_System.Repository.ProductRepository;
import com.Jspiders.Produc_Management_System.ResponseDto.OwnerDto;
import com.Jspiders.Produc_Management_System.entity.Address;
import com.Jspiders.Produc_Management_System.entity.IdGenerator;
import com.Jspiders.Produc_Management_System.entity.Owner;
import com.Jspiders.Produc_Management_System.entity.Product;
import com.Jspiders.Produc_Management_System.service.IOwnerService;

@Service
public class OwnerServiceImpl implements IOwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IdGeneratorRepo generatorRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    private String generateOwnerId() {
        IdGenerator gen = generatorRepo.save(new IdGenerator());
        int id = gen.getId();
        return id <= 9 ? "OWN00" + id : id <= 99 ? "OWN0" + id : "OWN" + id;
    }

    private String generateProductId() {
        IdGenerator gen = generatorRepo.save(new IdGenerator());
        int id = gen.getId();
        return id <= 9 ? "PROD00" + id : id <= 99 ? "PROD0" + id : "PROD" + id;
    }


    @Override
    public OwnerDto createOwner(OwnerDto ownerDto) {
        String ownerId = generateOwnerId();
        Owner owner = modelMapper.map(ownerDto, Owner.class);
        owner.setOwnerId(ownerId);

        if (ownerDto.getPassword() != null && !ownerDto.getPassword().isBlank()) {
            owner.setPassword(passwordEncoder.encode(ownerDto.getPassword()));
        }

        if (owner.getProducts() != null) {
            owner.getProducts().forEach(p -> {
                p.setPid(generateProductId());
                p.setOwner(owner);
            });
        }

        Owner saved = ownerRepository.save(owner);
        OwnerDto response = modelMapper.map(saved, OwnerDto.class);
        response.setPassword(null);
        return response;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        return ownerRepository.findAll().stream().map(o -> {
            OwnerDto dto = modelMapper.map(o, OwnerDto.class);
            dto.setPassword(null);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public OwnerDto getOwnerById(String ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found: " + ownerId));
        OwnerDto dto = modelMapper.map(owner, OwnerDto.class);
        dto.setPassword(null);
        return dto;
    }

    @Override
    public OwnerDto updateOwner(String ownerId, OwnerDto ownerDto) {
        Owner existing = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found: " + ownerId));

        existing.setName(ownerDto.getName());
        existing.setEmail(ownerDto.getEmail());
        existing.setPhno(ownerDto.getPhno());
        existing.setAge(ownerDto.getAge() != null ? ownerDto.getAge() : existing.getAge());

        if (ownerDto.getAddress() != null) {
            Address address = modelMapper.map(ownerDto.getAddress(), Address.class);
            existing.setAddress(address);
        }

        if (ownerDto.getPassword() != null && !ownerDto.getPassword().isBlank()) {
            existing.setPassword(passwordEncoder.encode(ownerDto.getPassword()));
        }

        Owner updated = ownerRepository.save(existing);
        OwnerDto dto = modelMapper.map(updated, OwnerDto.class);
        dto.setPassword(null);
        return dto;
    }

    @Override
    public void deleteOwner(String ownerId) {
        Owner existing = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found: " + ownerId));
        ownerRepository.delete(existing);
    }

    @Override
    public OwnerDto getOwnerByEmail(String email) {
        Owner owner = ownerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with email: " + email));
        OwnerDto dto = modelMapper.map(owner, OwnerDto.class);
        dto.setPassword(null);
        return dto;
    }

    @Override
    public OwnerDto getOwnerByPhno(String phno) {
        Owner owner = ownerRepository.findByPhno(phno)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with phone: " + phno));
        OwnerDto dto = modelMapper.map(owner, OwnerDto.class);
        dto.setPassword(null);
        return dto;
    }

   
    @Override
    public OwnerDto createOwnerWithProducts(OwnerDto ownerDto) {
        String ownerId = generateOwnerId();
        Owner owner = modelMapper.map(ownerDto, Owner.class);
        owner.setOwnerId(ownerId);

        if (ownerDto.getPassword() != null && !ownerDto.getPassword().isBlank()) {
            owner.setPassword(passwordEncoder.encode(ownerDto.getPassword()));
        }

        Owner savedOwner = ownerRepository.save(owner);

        if (ownerDto.getProducts() != null && !ownerDto.getProducts().isEmpty()) {
            List<Product> products = ownerDto.getProducts().stream().map(pdto -> {
                Product product = modelMapper.map(pdto, Product.class);
                product.setPid(generateProductId());
                product.setOwner(savedOwner);
                return product;
            }).collect(Collectors.toList());

            productRepository.saveAll(products);
            savedOwner.setProducts(products);
        }

        OwnerDto response = modelMapper.map(savedOwner, OwnerDto.class);
        response.setPassword(null);
        return response;
    }

}
