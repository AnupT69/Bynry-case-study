package com.Updated_Api_Bynry.Bynry_api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Updated_Api_Bynry.Bynry_api.DTO.ProductRequest;
import com.Updated_Api_Bynry.Bynry_api.Models.Product;
import com.Updated_Api_Bynry.Bynry_api.Response.ApiResponse;
import com.Updated_Api_Bynry.Bynry_api.Service.ProductService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<?> createProduct(@Validated @RequestBody ProductRequest request) {
	    try {
	        Product product = productService.createProduct(request);
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(new ApiResponse(
	                        "Product Created Successfully",
	                        product.getId(),
	                        "Success",
	                        LocalDateTime.now()
	                ));
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(new ApiResponse(
	                        e.getMessage(),
	                        null,
	                        "Failed",
	                        LocalDateTime.now()
	                ));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ApiResponse(
	                        "Something went wrong",
	                        null,
	                        "Error",
	                        LocalDateTime.now()
	                ));
	    }
	}
}
