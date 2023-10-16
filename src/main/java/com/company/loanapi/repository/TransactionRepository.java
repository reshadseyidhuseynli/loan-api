package com.company.loanapi.repository;

import com.company.loanapi.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransactionRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Transaction> transactionRowMapper;

    public int create(Transaction transaction) {
        String sql = "INSERT INTO transaction (action_status, final_status) " +
                "VALUES (:actionStatus, :finalStatus)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("actionStatus", transaction.getActionStatus().value());
        params.addValue("finalStatus", transaction.getFinalStatus().value());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,params, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Transaction getById(Integer id) {
        String sql = "SELECT * FROM transaction WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject(
                sql,
                params,
                transactionRowMapper
        );
    }

    public void update(Transaction transaction) {
        String sql = "UPDATE transaction SET " +
                "action_status = :actionStatus, reject_reason = :rejectReason, final_status = :finalStatus " +
                "WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("actionStatus", transaction.getActionStatus().value());
        params.addValue("rejectReason", transaction.getRejectReason());
        params.addValue("finalStatus", transaction.getFinalStatus().value());
        params.addValue("id", transaction.getId());

        jdbc.update(sql,params);
    }

}
