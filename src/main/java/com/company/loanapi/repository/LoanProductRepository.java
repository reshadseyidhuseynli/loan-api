package com.company.loanapi.repository;

import com.company.loanapi.domain.LoanProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoanProductRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<LoanProduct> loanProductRowMapper;

    public void create(LoanProduct loanProduct) {
        String sql = "INSERT INTO loan_product (loan_id, product_id) " +
                "VALUES(:loanId, :productId)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("loanId", loanProduct.getLoanId());
        params.addValue("productId", loanProduct.getProductId());


        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, params, keyHolder);
    }

    public List<LoanProduct> getByLoanId(Integer loanId) {
        String sql = "SELECT * FROM loan_product WHERE loan_id = :loan_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("loan_id", loanId);

        return jdbc.query(
                sql,
                params,
                loanProductRowMapper
        );
    }
}
