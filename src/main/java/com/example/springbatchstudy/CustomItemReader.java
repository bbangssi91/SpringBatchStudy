package com.example.springbatchstudy;

import org.springframework.batch.item.ItemReader;

import java.util.ArrayList;
import java.util.List;

public class CustomItemReader implements ItemReader<Customer> {

    private final List<Customer> customers;

    public CustomItemReader(List<Customer> customers){
        this.customers = new ArrayList<>(customers);
    }

    @Override
    public Customer read() throws Exception {

        if(!customers.isEmpty()){
            return customers.remove(0);
        }

        return null; // empty 상태
    }
}
