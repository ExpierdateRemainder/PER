package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@Service
@Primary
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long product_id) {
		// TODO Auto-generated method stub
		return productRepository.findById(product_id).get();
	}

	@Override
	public Product pushProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return productRepository.save(newProduct);
	}

	@Override
	public Product updateProduct(Product updatedProduct, Long product_id) {
		// TODO Auto-generated method stub
		productRepository.findById(product_id).get();
		updatedProduct.setId(product_id);
		return productRepository.save(updatedProduct);
	}

	@Override
	public void deleteProductById(Long product_id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(product_id);
		
	}

}
