package com.example.springapp1.services;

import com.example.springapp1.entitty.UserEntity;
import com.example.springapp1.exceptions.UserAlreadyExist;
import com.example.springapp1.exceptions.UserNotFound;
import com.example.springapp1.model.User;
import com.example.springapp1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new UserAlreadyExist ("Пользователь с таким именем уже существует");
        }

        return userRepository.save(user);
    }

    public User getOneUser(Long id) throws UserNotFound {
        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFound("Пользователь с таким id не найден");
        }

        return User.toModel(user.get());
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);

        return id;
    }
}
