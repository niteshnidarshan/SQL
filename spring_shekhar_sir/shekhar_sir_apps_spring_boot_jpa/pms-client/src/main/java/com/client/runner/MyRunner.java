package com.client.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static String ALL_PRODUCTS = "http://localhost:2727/pms/allProducts";
	private static String PRODUCT_BY_ID= "http://localhost:2727/pms/{id}";
	private static String ADD_PRODUCT = "http://localhost:2727/pms/product/add";
	private static String DELETE_PRODUCT = "http://localhost:2727/pms/product/delete/{id}";

	@Override
	public void run(String... args) throws Exception {
		/*
		 * exchange(p1,p2,p3,p4)
		 * p1 : url
		 * p2 : http method
		 * p3 : HttpEntity obj / null
		 * p4 : ParameterizedTypeReference object
		 */
		
		/*
		ParameterizedTypeReference<List<ProductDTO>> typeRef=new ParameterizedTypeReference<List<ProductDTO>>() {};
		ResponseEntity<List<ProductDTO>>  re = restTemplate.exchange(ALL_PRODUCTS, HttpMethod.GET, null, typeRef);
		List<ProductDTO>  dtosList = re.getBody();
		dtosList.forEach( dto -> {
			System.out.println("product id : "+ dto.getProductId());
			System.out.println("product name : "+ dto.getProductName());
			System.out.println("price : "+ dto.getPrice());
			System.out.println("manufacturer : "+dto.getManufacturer());
			System.out.println("==================================");
		});
		*/
		
		/*
		 * getForObject(p1,p2,p3)
		 * p1: url
		 * p2: response type
		 * p3: values
		 */
		/*
		ProductDTO pdto=restTemplate.getForObject(PRODUCT_BY_ID, ProductDTO.class, 109);
		System.out.println("product id : "+ pdto.getProductId());
		System.out.println("product name : "+pdto.getProductName());
		System.out.println("price : "+ pdto.getPrice());
		System.out.println("manufacturer : "+pdto.getManufacturer());
		System.out.println("==================================");
		*/
		
		/*
		HttpHeaders  headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ProductDTO productDto=new ProductDTO();
		productDto.setProductId(112);
		productDto.setProductName("TOY");
		productDto.setPrice(749.0);
		productDto.setManufacturer("Nikkon");
		HttpEntity  entity=new HttpEntity(productDto, headers);
		
		ResponseEntity<String> re=restTemplate.exchange(ADD_PRODUCT, HttpMethod.POST, entity, String.class);
		System.out.println(re.getBody());
		*/
		
		ResponseEntity<String> re = restTemplate.exchange(DELETE_PRODUCT, HttpMethod.DELETE, null, String.class, 112);
		System.out.println(re.getBody());
	}

}
