package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.service.ProductService;


@RestController //(@controller + @responseBody --> returned methods are directly serialized to resp body)
@RequestMapping("/products") // for mapping web requests onto methods
public class ProductController {
	// dep : service layer i/f
	
	@Autowired
	private ProductService productService;

	public ProductController() {
		System.out.println("in ctor of " + getClass());
	}

	// add REST API end point to add student details
	// URL : http://host:port/students , method=POST
	// request payload : StudentDTO : no id
	// resp : success --SC 201 , StudentDTO : id
	// resp : err --SC 500, Api Resp DTO
	
	@PostMapping
	public ResponseEntity<?> addNewProduct
	(@RequestBody ProductDTO dto) {
		System.out.println("in add student " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(productService.addProductDetails(dto));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// return ResponseEntity : SC 500
			// ApiResp DTO : mesg n timestamp
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	 
	@GetMapping("/")
	public ResponseEntity<?> getProduct
	(@RequestBody ProductDTO dto) {
//		System.out.println("in add student " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(productService.getAllProducts());
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// return ResponseEntity : SC 500
			// ApiResp DTO : mesg n timestamp
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById
	(@PathVariable Long id) {
//		System.out.println("in add student " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(productService.getProduct(id));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// return ResponseEntity : SC 500
			// ApiResp DTO : mesg n timestamp
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductById
	(@PathVariable Long id) {
//		System.out.println("in add student " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(productService.deleteProduct(id));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// return ResponseEntity : SC 500
			// ApiResp DTO : mesg n timestamp
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("/{id}/{name}")
	public ResponseEntity<?> updateProductById
	(@PathVariable Long id, @PathVariable String name) {
//		System.out.println("in add student " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(productService.updateProduct(id,name));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// return ResponseEntity : SC 500
			// ApiResp DTO : mesg n timestamp
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}
 
}
