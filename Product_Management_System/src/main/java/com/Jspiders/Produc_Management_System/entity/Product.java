package com.Jspiders.Produc_Management_System.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id

	private String pid;

	private Double price;
	private String companyName;
	private String productType;
	private LocalDate dateOfManufacture;
	private LocalDate expDate;
	private int ageOfProduct;
	private String details;

	@CollectionTable(name = "product_colors", joinColumns = @JoinColumn(name = "pid"))
	@Column(name = "color")
	@ElementCollection
	private List<String> color;

	@ManyToOne
	@JoinColumn(name = "owner_id")

	private Owner owner;
}
