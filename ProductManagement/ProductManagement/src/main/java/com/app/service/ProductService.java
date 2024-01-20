package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.entities.Product;

public interface ProductService {
	ProductDTO addProductDetails(ProductDTO product);
	List<ProductDTO> getAllProducts();
	Optional<Product> getProduct(Long id);
	Optional<Product> deleteProduct(Long id);
	ApiResponse updateProduct(Long id,String name);
	
	
//	Optional<Product> findById(Long id);
}
