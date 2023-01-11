package com.example.springapp1.controller;

import com.example.springapp1.entitty.ToDoEntity;
import com.example.springapp1.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todo")
@AllArgsConstructor
public class ToDoController {
    private ToDoService toDoService;
    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity toDoEntity,
                                     @RequestParam Long user_id) {
        try {
            return ResponseEntity.ok(toDoService.createTodo(toDoEntity, user_id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.updateTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
