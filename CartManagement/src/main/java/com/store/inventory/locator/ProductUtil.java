package com.store.inventory.locator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.store.inventory.domain.Product;

@Component
@PropertySource(value = "classpath:application.properties")
public class ProductUtil {
	@Autowired
	private RestTemplate template;	
	@Autowired
	private Environment env;
	public Product getProduct(Long productId) {
	
		String URL = "";
		URL = env.getProperty("productmanagement.url") + productId;
		Product product = template.getForObject(URL,Product.class);
		
		return product;
	}
}
