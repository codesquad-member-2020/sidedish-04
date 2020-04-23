package com.sidedish4.codesquad.sidedish.domain.dao;

import com.sidedish4.codesquad.sidedish.domain.entity.Menu;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends CrudRepository<Menu, Long> {


}
