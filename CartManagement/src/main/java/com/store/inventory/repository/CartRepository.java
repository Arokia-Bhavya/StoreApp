package com.store.inventory.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.store.inventory.domain.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long>{

}
