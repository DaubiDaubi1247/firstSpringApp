package com.example.springapp1.repository;

import com.example.springapp1.entitty.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
}
