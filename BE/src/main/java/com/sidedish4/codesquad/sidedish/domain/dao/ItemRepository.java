package com.sidedish4.codesquad.sidedish.domain.dao;

import com.sidedish4.codesquad.sidedish.domain.entity.Item;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item,Long> {
    @Query("select * from item where detail_hash = :detailHash")
    Optional<Item> findItemByDetailHash(@Param("detailHash") String deatilHash);
}
