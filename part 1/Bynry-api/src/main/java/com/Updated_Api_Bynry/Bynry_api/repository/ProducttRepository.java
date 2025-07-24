package com.Updated_Api_Bynry.Bynry_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Updated_Api_Bynry.Bynry_api.Models.Product;

public interface ProducttRepository extends JpaRepository<Product, Long> {

	Optional<Product> findBySku(Long sku);
	

}
