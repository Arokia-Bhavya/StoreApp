package com.store.inventory.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.store.inventory.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
