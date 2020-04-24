package com.sidedish4.codesquad.sidedish.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Long> {

    @Query("select * from menu where name = :name")
    Optional<Menu> findByName(@Param("name") String name);

}
