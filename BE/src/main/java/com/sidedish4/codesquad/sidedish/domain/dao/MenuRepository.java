package com.sidedish4.codesquad.sidedish.domain;

import com.sidedish4.codesquad.sidedish.domain.entity.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
}
