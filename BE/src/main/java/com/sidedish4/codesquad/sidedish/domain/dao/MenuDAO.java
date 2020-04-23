package com.sidedish4.codesquad.sidedish.domain.dao;

import com.sidedish4.codesquad.sidedish.domain.entity.Item;
import com.sidedish4.codesquad.sidedish.domain.entity.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MenuDAO {
    private Logger logger = LoggerFactory.getLogger(MenuDAO.class);

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MenuDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public String countAllUsers() {
        String sql = "show tables";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    public Menu findById(Long id) {
        String sql = "select * from menu where id = ?";
        RowMapper<Menu> menuMapper = new RowMapper<Menu>() {
            @Override
            public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
                Menu menu = new Menu();
                menu.setId(rs.getLong("id"));
                menu.setMenuName(rs.getString("menuName"));
                menu.setItems((List<Item>) rs.getObject("items"));
                return menu;
            }
        };

        return jdbcTemplate.queryForObject(sql, new Object[] {id}, menuMapper);
    }
}
