package com.company.loanapijdbc.repository;

import com.company.loanapijdbc.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransactionRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Transaction> transactionRowMapper;

    public void create(Transaction transaction) {
        String sql = "INSERT INTO transaction (action_status, final_status, customer_id) " +
                "VALUES (:actionStatus, :finalStatus, :customerId)";
        jdbc.update(sql, getParams(transaction));
    }

    public Transaction getById(Integer id) {
        String sql = "SELECT * FROM transaction WHERE id = :id";
        return jdbc.queryForObject(sql, getParams(id), transactionRowMapper);
    }

    public void update(Transaction transaction) {
        String sql = "UPDATE transaction SET " +
                "action_status = :actionStatus, reject_reason = :rejectReason, final_status = :finalStatus " +
                "WHERE id = :id";
        jdbc.update(sql, getParams(transaction));
    }

    private MapSqlParameterSource getParams(Transaction transaction) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", transaction.getId());
        params.addValue("actionStatus", transaction.getActionStatus().value());
        params.addValue("rejectReason", transaction.getRejectReason());
        params.addValue("finalStatus", transaction.getFinalStatus().value());
        params.addValue("customerId", transaction.getCustomerId());

        return params;
    }

    private MapSqlParameterSource getParams(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return params;
    }


}
