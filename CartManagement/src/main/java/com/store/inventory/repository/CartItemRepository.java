package com.store.inventory.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.store.inventory.domain.Cart;
import com.store.inventory.domain.CartItem;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem,Long>{

}
