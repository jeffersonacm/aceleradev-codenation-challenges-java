package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {
    @Query(value = "select * from acceleration a " +
            "inner join candidate ca " +
                "on a.id = ca.acceleration_id " +
            "inner join company c " +
                "on c.id = ca.company_id " +
            "where c.id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
