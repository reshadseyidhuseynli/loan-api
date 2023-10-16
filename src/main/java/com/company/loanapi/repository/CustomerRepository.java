package com.company.loanapi.repository;

import com.company.loanapi.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Customer> customerRowMapper;

    public Integer create(Customer customer) {
        String sql = "INSERT INTO customer (name, surname, patronymic, birthdate, gender, passport_number) " +
                "VALUES(:name, :surname, :patronymic, :birthdate, :gender, :passportNumber)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", customer.getName());
        params.addValue("surname", customer.getSurname());
        params.addValue("patronymic", customer.getPatronymic());
        params.addValue("birthdate", customer.getBirthdate());
        params.addValue("gender", customer.getGender().value());
        params.addValue("passportNumber", customer.getPassportNumber());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, params, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Customer getById(Integer id) {
        String sql = "SELECT * FROM customer WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject(
                sql,
                params,
                customerRowMapper
        );
    }

    public void update(Customer customer) {
        String sql = "UPDATE customer SET " +
                "name = :name, " +
                "surname = :surname, " +
                "patronymic = :patronymic, " +
                "birthdate = :birthdate, " +
                "gender = :gender, " +
                "passport_number = :passportNumber, " +
                "contact_id = :contactId, " +
                "transaction_id = :transactionId " +
                "WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", customer.getName());
        params.addValue("surname", customer.getSurname());
        params.addValue("patronymic", customer.getPatronymic());
        params.addValue("birthdate", customer.getBirthdate());
        params.addValue("gender", customer.getGender().value());
        params.addValue("passportNumber", customer.getPassportNumber());
        params.addValue("contactId", customer.getContactId());
        params.addValue("transactionId", customer.getTransactionId());
        params.addValue("id", customer.getId());

        jdbc.update(sql, params);
    }
}
