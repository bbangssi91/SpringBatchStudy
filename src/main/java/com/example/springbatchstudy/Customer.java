package com.example.springbatchstudy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthdate;
}
