package com.example.springbatchstudy;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class CustomItemWriter implements ItemWriter<Customer> {

    @Override
    public void write(List<? extends Customer> customers) throws Exception {
        customers.forEach(System.out :: println);
    }
}
