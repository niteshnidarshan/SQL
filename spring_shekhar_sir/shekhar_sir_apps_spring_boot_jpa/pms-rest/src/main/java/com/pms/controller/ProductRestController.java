package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.model.ProductDTO;
import com.pms.service.IProductService;



@RestController
public class ProductRestController {
	@Autowired
	IProductService  service;
	
	@GetMapping(value="/allProducts", produces="application/json")
	public ResponseEntity<List<ProductDTO>>  findAllProducts() {
		List<ProductDTO>  productDTOList=service.searchAllProducts();
		return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces= {"application/json"})
	public  ProductDTO  findProductById(@PathVariable Integer id) {
		return service.searchProductById(id);
	}
	
	@GetMapping(value="/products/{manufacturer}", produces="application/json")
	public List<ProductDTO>  findProductsByManufacturer(@PathVariable String manufacturer) {
		return service.searchProductsByManufacturer(manufacturer);	
	}
	
	@PostMapping(value="/product/add", consumes="application/json")
	public String addProduct(@RequestBody ProductDTO productDTO) {
		return service.addProduct(productDTO);		
	}
	
	@PutMapping(value="/product/update", consumes="application/json")
	public  String  updateProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO dto=service.updateProduct(productDTO);
		if(dto==null) {
			return "product doesn't exist";
		}
		else {
			return "product is updated";
		}
	}
	
	@DeleteMapping(value="/product/delete/{id}")
	public String deleteProductById(@PathVariable Integer id) {
		return service.deleteProductById(id);
	}

}
