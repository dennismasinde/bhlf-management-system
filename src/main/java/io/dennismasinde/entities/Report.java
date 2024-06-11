package io.dennismasinde.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "clubhouse_reports_tbl")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    private LocalDateTime createdAt;
    private String good;
    private String bad;
    private String recommendation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
