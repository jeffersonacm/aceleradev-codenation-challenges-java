package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {
    @EmbeddedId
    private Submission_id id;

    @NotNull
    @Column(name = "score")
    private Float score;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public class Submission_id implements Serializable {
        @ManyToOne
        @NotNull
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @NotNull
        @JoinColumn(name = "challenge_id")
        private Challenge challenge;
    }
}


