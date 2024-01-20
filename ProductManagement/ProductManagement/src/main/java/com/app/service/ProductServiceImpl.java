package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductDao;
import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	// dep : dao layer i/f
	@Autowired
	private ProductDao productDao;
	// dep : ModelMapper
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductDTO addProductDetails(ProductDTO dto) {
		// dto --> entity
		Product product = mapper.map(dto, Product.class);
		// entity --> dto
		return mapper.map
				(productDao.save(product), ProductDTO.class);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
        List<Product> products = productDao.findAll();

        return products.stream()
                .map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());

	}

	@Override
	public Optional<Product> getProduct(Long id) {
		// TODO Auto-generated method stub
	   Optional<Product> ref = productDao.findById(id);
		return ref;
	}

	@Override
	public Optional<Product> deleteProduct(Long id) {
//		Optional<Product> ref = Optional.empty();
		Optional<Product> ref = productDao.findById(id);
		if(ref.isPresent())
		{
			productDao.deleteById(id);
		}
		return ref;
	}

	@Override
	public ApiResponse updateProduct(Long id,String name) {
		// TODO Auto-generated method stub
		Optional<Product> ref = productDao.findById(id);
		if(ref.isPresent())
		{
		Product data=ref.get();
         data.setName(name);
         ApiResponse res=new ApiResponse();
         res.setMessage("name updated successfully");
         return res;
		
		}
		else {
			
			return null;
		}
	}

	

}
