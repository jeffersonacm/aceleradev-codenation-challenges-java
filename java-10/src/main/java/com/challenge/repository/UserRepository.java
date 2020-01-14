package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u.id, u.created_at, u.email, u.full_name, u.nickname, u.password " +
            "from users u " +
            "inner join candidate c " +
                "on c.user_id = u.id " +
            "inner join acceleration a " +
                "on a.id = c.acceleration_id " +
            "where a.name = :aName", nativeQuery = true)
    List<User> findUserByAccelerationName(@Param("aName") String aName);

    @Query(value = "select u.id, u.created_at, u.email, u.full_name, u.nickname, u.password " +
            "from users u " +
            "inner join candidate ca " +
                "on u.id = ca.user_id " +
            "inner join company co " +
            "   on ca.company_id = co.id where co.id = :companyId\n", nativeQuery = true)
    List<User> findUsersByCompanyID(@Param("companyId") Long companyId);
}
