package com.example.springbatchstudy;

import org.springframework.batch.core.ItemProcessListener;

public class CustomItemProcessListener implements ItemProcessListener<Customer, Customer> {

    @Override
    public void beforeProcess(Customer customer) {

    }

    @Override
    public void afterProcess(Customer customer, Customer customer2) {
        System.out.println(" == > Thread : " + Thread.currentThread().getName() + " , Process item : " + customer.getId() );
    }

    @Override
    public void onProcessError(Customer customer, Exception e) {

    }
}
