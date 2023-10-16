package com.company.loanapi.repository;

import com.company.loanapi.domain.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Product> productRowMapper;

    public int create(Product product) {
        String sql = "INSERT INTO product (name, price) " +
                "VALUES(:name, :price)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", product.getName());
        params.addValue("price", product.getPrice());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, params, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Product getById(Integer id) {
        String sql = "SELECT * FROM product WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject(
                sql,
                params,
                productRowMapper
        );
    }
}
