package io.dennismasinde.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clubhouse_members_tbl")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @Min(1)
    @Max(100)
    private int age;
    private String phone;
    @Email
    private String email;
}
