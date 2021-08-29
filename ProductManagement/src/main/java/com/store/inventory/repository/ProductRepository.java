package com.store.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.store.inventory.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll();

}
