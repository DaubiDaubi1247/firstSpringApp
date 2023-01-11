package com.example.springapp1.controller;

import com.example.springapp1.exceptions.UserAlreadyExist;
import com.example.springapp1.exceptions.UserNotFound;
import com.example.springapp1.entitty.UserEntity;
import com.example.springapp1.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {

            userService.registration(user);
            return ResponseEntity.ok("Пользователь сохранен");

        } catch (UserAlreadyExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("ошибка");
        }

    }

    @GetMapping("/all")
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
           return ResponseEntity.ok(userService.getOneUser(id));
        } catch (UserNotFound e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка!");
        }
    }
}
