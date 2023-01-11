package com.example.springapp1.repository;

import com.example.springapp1.entitty.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {
}
