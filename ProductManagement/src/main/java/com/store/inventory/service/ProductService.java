
  package com.store.inventory.service;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.stereotype.Service;
  
  import com.store.inventory.domain.User; 
  import com.store.inventory.locator.UserUtil;
  
  @Service public class ProductService {
  
  @Autowired private UserUtil userUtil;
  
  public boolean isAdmin(Long userId) { User user=userUtil.getUser(userId);
  if(user!=null && user.getAdmin()==1) return true; return false; } }
 