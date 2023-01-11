package com.example.springapp1.model;

import com.example.springapp1.entitty.ToDoEntity;
import com.example.springapp1.entitty.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String userName;
    private List<ToDo> todos;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setTodos(getToDoModels(entity.getTodos()));

        return model;
    }

    private static List<ToDo> getToDoModels(List<ToDoEntity> toDoEntities) {
        return toDoEntities.stream()
                .map(ToDo::toModel)
                .collect(Collectors.toList());
    }
}
