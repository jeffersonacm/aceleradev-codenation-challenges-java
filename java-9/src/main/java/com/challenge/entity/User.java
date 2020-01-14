package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(name = "fullname")
    private String fullname;

    @NotNull
    @Size(max = 100)
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(name = "nickname")
    private String nickname;

    @NotNull
    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Submission> submissionList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Candidate> candidateList;
}
