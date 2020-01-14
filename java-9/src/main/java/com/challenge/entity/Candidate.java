package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {
    @EmbeddedId
    private CandidateId id;

    @NotNull
    @Column(name = "status")
    private Integer status;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @Embeddable
    @Data
    public class CandidateId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "acceleration_id")
        private Acceleration acceleration;

        @ManyToOne
        @JoinColumn(name = "company_id")
        private Company company;
    }
}
