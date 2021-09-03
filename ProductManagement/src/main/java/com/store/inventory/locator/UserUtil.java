
  package com.store.inventory.locator; 
  import  org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.context.annotation.PropertySource; 
  import org.springframework.core.env.Environment; 
  import  org.springframework.stereotype.Component; 
  import org.springframework.web.client.RestTemplate;

import com.store.inventory.domain.User;
  
  
  @Component
  
  @PropertySource(value = "classpath:application.properties") public class
  UserUtil {
  
  @Autowired private RestTemplate template;
  
  @Autowired private Environment env; 
  
  public User getUser(Long userId) {
  
  String URL = ""; URL = env.getProperty("usermanagement.url") + userId;
  User  user = template.getForObject(URL,User.class);
  
  return user; 
  } 
  }
 