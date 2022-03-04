package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Product;


public interface ProductService {
	List<Product> getAllProducts();
	
	 Product getProductById(Long product_id);

	    Product pushProduct(Product newProduct);

	    Product updateProduct(Product updatedProduct, Long product_id);

	    void deleteProductById(Long product_id);


}
