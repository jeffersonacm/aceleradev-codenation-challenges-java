package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    @Query(value = "select COALESCE(max(s.score), 0) " +
            "from submission s " +
            "inner join challenge c " +
                "on s.challenge_id = c.id where c.id = :challengeId", nativeQuery = true)
    BigDecimal findMaxScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "select s.created_at, s.score, s.user_id, s.challenge_id " +
            "from submission s " +
            "inner join challenge c " +
                "on s.challenge_id = c.id " +
            "inner join acceleration a " +
                "on a.challenge_id = c.id " +
            "where c.id = :challenge_id and a.id = :acceleration_id", nativeQuery = true)
    List<Submission> findByChallangeIdAndAccelerationId
            (@Param("challenge_id") Long challengeId, @Param("acceleration_id") Long accelerationId);
}
