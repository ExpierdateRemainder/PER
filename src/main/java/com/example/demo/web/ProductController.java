package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;
import com.example.demo.model.User;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/{product_id}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long product_id){
		productService.deleteProductById(product_id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{product_id}")
	public ResponseEntity<?> getUserById(@PathVariable Long product_id){
		Product product = productService.getProductById(product_id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> pushUser(@RequestBody Product product){
		productService.pushProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	------------------------------product details for particular user---------
	@GetMapping("/productbyid/{user_id}")
	public List<Product> getProductById(@PathVariable Long user_id){
		List<Product> products = productService.getAllProducts();
		List<Product> products2 = products.stream().filter(s->s.getUser().getId()==user_id).toList();
		return products2;
	}

}
