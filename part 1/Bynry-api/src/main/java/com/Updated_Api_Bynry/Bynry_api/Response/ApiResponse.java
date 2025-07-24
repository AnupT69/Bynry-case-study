package com.Updated_Api_Bynry.Bynry_api.Response;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
	 private String message;
	 private Long productId;
	 private String status;
	 private LocalDateTime timestamp;
	 

}
