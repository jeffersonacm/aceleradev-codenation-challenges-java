package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "select distinct co.* from company co " +
            "inner join candidate ca " +
            "   on co.id = ca.company_id " +
            "inner join acceleration a " +
            "on ca.acceleration_id = a.id " +
            "where a.id = :acceleration_id", nativeQuery = true)
    List<Company> findByAccelerationId(@Param("acceleration_id") Long acceleration_id);

    @Query(value = "select co.id, co.created_at, co.name, co.slug " +
            "from company co " +
            "inner join candidate ca " +
                "on co.id = ca.company_id " +
            "inner join users u " +
                "on u.id = ca.user_id " +
            "where u.id = :user_id", nativeQuery = true)
    List<Company> findByUserId(@Param("user_id") Long userId);

}
