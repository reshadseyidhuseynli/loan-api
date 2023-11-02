package com.company.loanapijdbc.repository;

import com.company.loanapijdbc.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ContactRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public int create(Contact contact) {
        String sql = "INSERT INTO contact (home_number, work_number, mobile_number, email) " +
                "VALUES(:homeNumber, :workNumber, :mobileNumber, :email)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, getParams(contact), keyHolder);
        return keyHolder.getKey().intValue();
    }

    private MapSqlParameterSource getParams(Contact contact) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("homeNumber", contact.getHomeNumber());
        params.addValue("workNumber", contact.getWorkNumber());
        params.addValue("mobileNumber", contact.getMobileNumber());
        params.addValue("email", contact.getEmail());

        return params;
    }

}
