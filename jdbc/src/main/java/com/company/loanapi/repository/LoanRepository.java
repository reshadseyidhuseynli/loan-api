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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, getParams(loan), keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Loan getById(Integer id) {
        String sql = "SELECT * FROM loan WHERE id = :id";
        return jdbc.queryForObject(sql, getParams(id), loanRowMapper);
    }

    public void update(Loan loan) {
        String sql = "UPDATE loan SET " +
                "total_amount = :totalAmount, " +
                "pre_amount = :preAmount, " +
                "interest_rate = :interestRate " +
                "WHERE id = :id";
        jdbc.update(sql, getParams(loan));
    }

    private MapSqlParameterSource getParams(Loan loan) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", loan.getId());
        params.addValue("totalAmount", loan.getTotalAmount());
        params.addValue("preAmount", loan.getPreAmount());
        params.addValue("interestRate", loan.getInterestRate());
        params.addValue("customerId", loan.getCustomerId());

        return params;
    }

    private MapSqlParameterSource getParams(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return params;
    }
}
