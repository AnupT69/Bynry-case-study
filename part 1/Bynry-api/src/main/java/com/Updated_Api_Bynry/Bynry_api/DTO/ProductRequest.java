package com.Updated_Api_Bynry.Bynry_api.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {

	@NotBlank(message="Name is required")
	private String name;
	
	@NotNull(message="SKU is required")
	private Long sku;

	@NotNull(message="Price is required")
	@Positive(message="Price must be greater than 0")
	private Double price;
	
	@NotNull(message="Warehouse ID is required")
	private Long warehouseId;
	
	@NotNull(message = "Initial quantity is required")
	@Min(value = 0 , message = "Quantity cannot be negative")
	private Integer initialQuantity;

	
	
}
