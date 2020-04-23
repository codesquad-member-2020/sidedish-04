package com.sidedish4.codesquad.sidedish.domain.dao;

import com.sidedish4.codesquad.sidedish.domain.entity.Badge;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BadgeRepository extends CrudRepository<Badge, Long> {
    @Query("select EXISTS(select * from badge where badge_name = :BadgeName) as success;")
    boolean existsByBadgeName(@Param("BadgeName") String BadgeName);

    @Query("select * from badge where badge_name = :BadgeName")
    Optional<Badge> findBadgeByBadgeName (@Param("BadgeName") String BadgeName);
}
