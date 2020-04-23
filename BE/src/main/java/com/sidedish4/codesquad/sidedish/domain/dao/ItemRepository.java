package com.sidedish4.codesquad.sidedish.domain.dao;

import com.sidedish4.codesquad.sidedish.domain.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
