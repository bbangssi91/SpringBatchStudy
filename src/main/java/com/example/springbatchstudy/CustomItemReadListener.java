package com.example.springbatchstudy;


import org.springframework.batch.core.ItemReadListener;

public class CustomItemReadListener implements ItemReadListener {


    @Override
    public void beforeRead() {
        System.out.println(">> Before read");

    }

    @Override
    public void afterRead(Object o) {
        System.out.println(">> After read");

    }

    @Override
    public void onReadError(Exception e) {
        System.out.println(">> On read Error");

    }
}
