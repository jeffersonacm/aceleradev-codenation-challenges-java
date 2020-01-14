package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {
    @Query(value = "select *" +
            "from candidate c " +
            "where user_id = :user_id and company_id = :company_id and acceleration_id = :acceleration_id", nativeQuery = true)
    Optional<Candidate> findByIdUserIdCompanyIdAcceleration(@Param("user_id") Long userId,
                                                            @Param("company_id") Long companyId,
                                                            @Param("acceleration_id") Long accelerationId);

    @Query(value = "select *" +
            "from candidate c " +
            "where company_id = :company_id", nativeQuery = true)
    List<Candidate> findByIdCompany(@Param("company_id") Long companyId);

    @Query(value = "select *" +
            "from candidate c " +
            "where acceleration_id = :acceleration_id", nativeQuery = true)
    List<Candidate> findById_Acceleration(@Param("acceleration_id") Long accelerationId);
}
