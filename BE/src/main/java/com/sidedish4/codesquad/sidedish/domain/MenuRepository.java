package com.sidedish4.codesquad.sidedish.domain;

import com.sidedish4.codesquad.sidedish.web.dto.DetailResponseDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Long> {

    @Query("select * from menu where name = :name")
    Optional<Menu> findByName(@Param("name") String name);

    @Query("select top_image,thumb_images,product_description,point,delivery_info,delivery_fee,prices,detail_section from item where id = :id")
    Optional<DetailResponseDto> findDetailByItemId(@Param("id") String id);

    @Query("select * from item where item.id = :id and item.menu = (select id from menu where menu.name = :name)")
    Optional<Item> findItemByIdAndMenuName(@Param("id") Long id , @Param("name") String name);
}
