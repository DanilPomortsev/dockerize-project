package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.User;
import org.example.models.UserModel;
import org.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserModel createNewUser(UserModel userModel){
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setDescription(userModel.getDescription());
        User savedUser = userRepository.save(user);
        userModel.setId(savedUser.getId());
        return userModel;
    }

    public List<UserModel> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserModel::fromEntities).collect(Collectors.toList());
    }
}
