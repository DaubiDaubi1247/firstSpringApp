package com.example.springapp1.services;

import com.example.springapp1.entitty.ToDoEntity;
import com.example.springapp1.entitty.UserEntity;
import com.example.springapp1.exceptions.ToDoNotFound;
import com.example.springapp1.exceptions.UserNotFound;
import com.example.springapp1.model.ToDo;
import com.example.springapp1.repository.ToDoRepository;
import com.example.springapp1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    public ToDo createTodo(ToDoEntity toDoEntity,
                           Long user_id) throws UserNotFound {
        Optional<UserEntity> user = userRepository.findById(user_id);

        if (user.isEmpty()) {
            throw new UserNotFound("Пользователь с id=" + user_id + " не найден");
        }

        toDoEntity.setUser(user.get());
        return ToDo.toModel(toDoRepository.save(toDoEntity));
    }

    public ToDo updateTodo(Long id) throws ToDoNotFound {
        Optional<ToDoEntity> todo = toDoRepository.findById(id);

        if (todo.isEmpty()) {
            throw new ToDoNotFound("todo с id=" + id + " не найден");
        }

        todo.get().setIsCompleated(!todo.get().getIsCompleated());
        return ToDo.toModel(toDoRepository.save(todo.get()));
    }
}
