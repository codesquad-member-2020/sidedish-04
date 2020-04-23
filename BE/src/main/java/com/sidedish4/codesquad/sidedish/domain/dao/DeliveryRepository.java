package com.sidedish4.codesquad.sidedish.domain.dao;

import com.sidedish4.codesquad.sidedish.domain.entity.Delivery;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    @Query("select EXISTS(select * from delivery where delivery_type = :deliveryType) as success;")
    boolean existsByDeliveryType(@Param("deliveryType") String deliveryType);

    @Query("select * from delivery where delivery_type = :deliveryType")
    Optional<Delivery> findDeliveryByDeliveryType (@Param("deliveryType") String deliveryType);
}
