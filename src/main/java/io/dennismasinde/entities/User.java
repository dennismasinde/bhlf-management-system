package io.dennismasinde.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clubhouse_users_tbl")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @NotNull
    private String phone;
    @Email
    private String email;
}
