package com.company.loanapijdbc.repository;

import com.company.loanapijdbc.domain.Customer;
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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, getParams(customer), keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Customer getById(Integer id) {
        String sql = "SELECT * FROM customer WHERE id = :id";
        return jdbc.queryForObject(sql, getParams(id), customerRowMapper);
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
                "address_id = :addressId " +
                "WHERE id = :id";
        jdbc.update(sql, getParams(customer));
    }

    private MapSqlParameterSource getParams(Customer customer) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", customer.getId());
        params.addValue("name", customer.getName());
        params.addValue("surname", customer.getSurname());
        params.addValue("patronymic", customer.getPatronymic());
        params.addValue("birthdate", customer.getBirthdate());
        params.addValue("gender", customer.getGender().value());
        params.addValue("passportNumber", customer.getPassportNumber());
        params.addValue("contactId", customer.getContactId());
        params.addValue("addressId", customer.getAddressId());

        return params;
    }

    private MapSqlParameterSource getParams(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return params;
    }
}
