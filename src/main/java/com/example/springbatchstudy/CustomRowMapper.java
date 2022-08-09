package com.example.springbatchstudy;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                 rs.getLong("id")
                ,rs.getString("firstName")
                ,rs.getString("lastName")
                ,rs.getString("birthdate"));
    }
}