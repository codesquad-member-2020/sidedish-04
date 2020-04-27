package com.sidedish4.codesquad.sidedish.domain;

import com.sidedish4.codesquad.sidedish.web.dto.DetailResponseDto;
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

    public DetailResponseDto findById(Long id) {
        String sql = "select * from item where id = ?";
        String sqlForThumbImage = "select url from thumb_image where item = ?";
        String sqlForDetailSection = "select url from detail_section where item = ?";
        RowMapper<DetailResponseDto> detailMapper = new RowMapper<DetailResponseDto>() {
            @Override
            public DetailResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                String top_image = rs.getString("top_image");
                String description = rs.getString("description");
                String point = rs.getString("point");
                String delivery_info = rs.getString("delivery_info");
                String delivery_fee = rs.getString("delivery_fee");
                String n_price = rs.getString("n_price");
                String s_price = rs.getString("s_price");
                List<String> prices = new ArrayList<>();
                if (n_price != null) prices.add(n_price);
                if (s_price != null) prices.add(s_price);
                List<String> thumImages = jdbcTemplate.queryForList(sqlForThumbImage, new Object[]{id}, String.class);
                List<String> detailSections = jdbcTemplate.queryForList(sqlForDetailSection, new Object[]{id}, String.class);
                DetailResponseDto detailResponseDto = new DetailResponseDto(top_image, description, point, delivery_info, delivery_fee, thumImages, prices, detailSections);
                return detailResponseDto;
            }
        };
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, detailMapper);
    }
}
