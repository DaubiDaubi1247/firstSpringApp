package com.example.springapp1.model;

import com.example.springapp1.entitty.ToDoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ToDo {
    private Long id;
    private String title;
    private Boolean isCompleated;

    public static ToDo toModel(ToDoEntity toDoEntity) {
        ToDo model = new ToDo();
        model.setId(toDoEntity.getId());
        model.setTitle(toDoEntity.getTitle());
        model.setIsCompleated(toDoEntity.getIsCompleated());

        return model;
    }

}
