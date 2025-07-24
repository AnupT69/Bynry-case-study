package com.Updated_Api_Bynry.Bynry_api.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.Updated_Api_Bynry.Bynry_api.DTO.ProductRequest;
import com.Updated_Api_Bynry.Bynry_api.Models.Inventory;
import com.Updated_Api_Bynry.Bynry_api.Models.Product;
import com.Updated_Api_Bynry.Bynry_api.repository.InventoryRepository;
import com.Updated_Api_Bynry.Bynry_api.repository.ProducttRepository;

@Service
public class ProductService {
	private final ProducttRepository productRepository;
	
	private final InventoryRepository inventoryRepository;
	
	public ProductService(ProducttRepository prepo,InventoryRepository inventRepo) {
		this.productRepository = prepo;
		this.inventoryRepository  = inventRepo;
	}
	
	
	public Product createProduct(ProductRequest request)
	{
		if(productRepository.findBySku((Long) request.getSku()).isPresent()) {
			throw new RuntimeException("SKU already exists");
			
			
		}

		Product product = Product.builder()
                .name(request.getName())
                .sku((Long)request.getSku())
                .price(request.getPrice())
                .warehouseId(request.getWarehouseId())
                .build();
		  product = productRepository.save(product);

	        Inventory inventory = Inventory.builder()
	                .productId(product.getId())
	                .wareHouseId(request.getWarehouseId())
	                .quantity(request.getInitialQuantity())
	                .build();
	        inventoryRepository.save(inventory);

	        return product;
		
	}
	

}
