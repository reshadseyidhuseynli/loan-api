package com.company.loanapijdbc.repository;

import com.company.loanapijdbc.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public void create(Product product) {
        String sql = "INSERT INTO product (name, price, loan_id) " +
                "VALUES(:name, :price, :loanId)";
        jdbc.update(sql, getParams(product));
    }

    public MapSqlParameterSource getParams(Product product) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", product.getName());
        params.addValue("price", product.getPrice());
        params.addValue("loanId", product.getLoanId());

        return params;
    }

}
