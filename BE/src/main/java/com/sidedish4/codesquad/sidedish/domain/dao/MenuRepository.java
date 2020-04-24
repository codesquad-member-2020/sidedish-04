package com.sidedish4.codesquad.sidedish.domain.dao;

import com.sidedish4.codesquad.sidedish.domain.entity.Badge;
import com.sidedish4.codesquad.sidedish.domain.entity.Delivery;
import com.sidedish4.codesquad.sidedish.domain.entity.Menu;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    @Query("select EXISTS(select * from badge where badge_name = :badgeName) as success")
    boolean existsBadgeByBadgeId(@Param("badgeName") String badgeName);

    @Query("select * from badge where badge_name = :badgeName")
    Optional<Badge> findBadgeByBadgeName(@Param("badgeName") String badgeName);

    @Modifying
    @Query("insert into badge(badge_name) values(:badgeName)")
    void createBadge(@Param("badgeName") String badgeName);

    @Query("select EXISTS(select * from delivery where delivery_type = :deliveryType) as success")
    boolean existsDeliveryByDeliveryType(@Param("deliveryType") String deliveryType);

    @Query("select * from delivery where delivery_type = :deliveryType")
    Optional<Delivery> findDeliveryByDeliveryType(@Param("deliveryType") String deliveryType);

    @Modifying
    @Query("insert into delivery(delivery_type) values(:deliveryType)")
    void createDelivery(@Param("deliveryType") String deliveryType);

}
