package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entities.User;

@Data
@AllArgsConstructor
public class UserModel {
    @JsonIgnore
    private Long id;
    private String password;
    private String email;
    private String description;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public static UserModel fromEntities(User user) {
        return new UserModel(user.getId(), user.getPassword(), user.getEmail(), user.getDescription());
    }
}
