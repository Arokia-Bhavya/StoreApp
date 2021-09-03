package com.store.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.inventory.domain.Product;
import com.store.inventory.locator.ProductUtil;
import com.store.inventory.locator.UserUtil;

@Service
public class CartService {
	@Autowired
	private ProductUtil productUtil;
	
	public boolean isProductExist(Long productId)	
	{
		Product product=productUtil.getProduct(productId);
		if(product!=null && product.getId()!=null)
			return true;
		return false;		
	}
}
