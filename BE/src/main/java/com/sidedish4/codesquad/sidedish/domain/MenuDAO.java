package com.sidedish4.codesquad.sidedish.domain;

import com.sidedish4.codesquad.sidedish.web.dto.DetailDto;
import com.sidedish4.codesquad.sidedish.web.dto.ItemResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDAO {
    private Logger logger = LoggerFactory.getLogger(MenuDAO.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MenuDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DetailDto findDetailByItemId(Long id) {
        String sql = "select * from item where id = ?";
        String sqlForThumbImage = "select url from thumb_image where item = ?";
        String sqlForDetailSection = "select url from detail_section where item = ?";
        RowMapper<DetailDto> detailMapper = new RowMapper<DetailDto>() {
            @Override
            public DetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                String top_image = rs.getString("top_image");
                String description = rs.getString("description");
                String point = rs.getString("point");
                String delivery_info = rs.getString("delivery_info");
                String delivery_fee = rs.getString("delivery_fee");
                String n_price = rs.getString("n_price");
                String s_price = rs.getString("s_price");
                s_price = s_price.replace("원","");
                List<String> prices = new ArrayList<>();
                if (n_price != null) prices.add(n_price);
                if (s_price != null) prices.add(s_price);
                List<String> thumImages = jdbcTemplate.queryForList(sqlForThumbImage, new Object[]{id}, String.class);
                List<String> detailSections = jdbcTemplate.queryForList(sqlForDetailSection, new Object[]{id}, String.class);
                DetailDto detailDto = new DetailDto(top_image, description, point, delivery_info, delivery_fee, thumImages, prices, detailSections);
                return detailDto;
            }
        };
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, detailMapper);
    }

    public List<ItemResponseDto> findMenuItemsByMenuId(Long menuId) {
        String sql = "select * from item where item.menu = ?";
        String sqlForDeliveryType = "select type from delivery where delivery.item = ?";
        String sqlForBadge = "select name from badge where badge.item = ?";
        List<ItemResponseDto> itemsMapper = jdbcTemplate.query(sql,new Object[]{menuId}, new RowMapper<ItemResponseDto>() {
            @Override
            public ItemResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                String id = rs.getString("id");
                String image = rs.getString("image");
                String alt = rs.getString("alt");
                List<String> deliveryTypes = jdbcTemplate.queryForList(sqlForDeliveryType, new Object[]{id}, String.class);
                String title = rs.getString("title");
                String description = rs.getString("description");
                String nPrice = rs.getString("n_price");
                String sPrice = rs.getString("s_price");
                sPrice = sPrice.replace("원","");
                List<String> badges = jdbcTemplate.queryForList(sqlForBadge, new Object[]{id}, String.class);
                return new ItemResponseDto(id, image, alt, deliveryTypes, title, description, nPrice, sPrice, badges);
            }
        });
        return itemsMapper;
    }

    public ItemResponseDto findItemByItemId(Long id) {
        String sql = "select * from item where id = ?";
        String sqlForDeliveryType = "select type from delivery where id = ?";
        String sqlForBadge = "select name from badge where id = ?";
        RowMapper<ItemResponseDto> itemMapper = new RowMapper<ItemResponseDto>() {
            @Override
            public ItemResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                String id = rs.getString("id");
                String image = rs.getString("image");
                String alt = rs.getString("alt");
                List<String> deliveryTypes = jdbcTemplate.queryForList(sqlForDeliveryType, new Object[]{id}, String.class);
                String title = rs.getString("title");
                String description = rs.getString("description");
                String nPrice = rs.getString("n_price");
                String sPrice = rs.getString("s_price");
                sPrice = sPrice.replace("원","");
                List<String> badges = jdbcTemplate.queryForList(sqlForBadge, new Object[]{id}, String.class);
                return new ItemResponseDto(id, image, alt, deliveryTypes, title, description, nPrice, sPrice, badges);
            }
        };
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, itemMapper);
    }
}
