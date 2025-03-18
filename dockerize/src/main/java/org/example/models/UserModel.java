package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entities.User;

@Data
@AllArgsConstructor
public class UserModel {
    @JsonIgnore
    private Long id;
    private String email;
    private String password;
    private String description;

    public static UserModel fromEntities(User user) {
        return new UserModel(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getDescription()
        );
    }
}
