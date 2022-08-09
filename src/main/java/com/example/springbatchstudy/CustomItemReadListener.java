package com.example.springbatchstudy;

import org.springframework.batch.core.ItemReadListener;

public class CustomItemReadListener implements ItemReadListener<Customer> {

    @Override
    public void beforeRead() {

    }

    @Override
    public void afterRead(Customer customer) {
        System.out.println(" == > Thread : " + Thread.currentThread().getName() + " , Read item : " + customer.getId());
    }

    @Override
    public void onReadError(Exception e) {

    }
}
