package io.dennismasinde.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clubhouse_leads_tbl")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @Min(1)
    @Max(100)
    private int age;
    @NotNull
    @Size(min = 10, max = 13)
    private String phone;
    @Email
    private String email;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "converted_member_id")
    private Member converted;
}
