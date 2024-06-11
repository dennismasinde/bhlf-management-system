package io.dennismasinde.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clubhouse_next_of_kin_tbl")
public class Kin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kinId;
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @NotNull
    @Size(min = 10, max = 13)
    private String phone;
    @Email
    private String email;
    @ManyToOne
    @JoinColumn(name = "lead_id")
    private Lead lead;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
