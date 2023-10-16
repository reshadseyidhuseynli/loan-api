package com.company.loanapi.repository;

import com.company.loanapi.domain.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoanRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Loan> loanRowMapper;

    public int create(Loan loan) {
        String sql = "INSERT INTO loan (interest_rate, customer_id) " +
                "VALUES(:interestRate, :customerId)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("interestRate", loan.getInterestRate());
        params.addValue("customerId", loan.getCustomerId());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, params, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Loan getById(Integer id) {
        String sql = "SELECT * FROM loan WHERE id = id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject(
                sql,
                params,
                loanRowMapper
        );
    }

    public void update(Loan loan) {
        String sql = "UPDATE loan SET " +
                "total_amount = :totalAmount, " +
                "pre_amount = :preAmount, " +
                "interest_rate = :interestRate " +
                "WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("totalAmount", loan.getTotalAmount());
        params.addValue("preAmount", loan.getPreAmount());
        params.addValue("interestRate", loan.getInterestRate());
        params.addValue("id", loan.getId());

        jdbc.update(sql,params);
    }
}
