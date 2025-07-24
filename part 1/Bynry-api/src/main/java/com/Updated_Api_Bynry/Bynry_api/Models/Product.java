package com.Updated_Api_Bynry.Bynry_api.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false,unique=true)
	private long sku;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private Long warehouseId;

}
