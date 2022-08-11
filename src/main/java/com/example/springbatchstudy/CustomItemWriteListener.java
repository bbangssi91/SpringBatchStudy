package com.example.springbatchstudy;

import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class CustomItemWriteListener implements ItemWriteListener {

    @Override
    public void beforeWrite(List list) {
        System.out.println(">> before Write");
    }

    @Override
    public void afterWrite(List list) {
        System.out.println(">> After Write");
    }

    @Override
    public void onWriteError(Exception e, List list) {
        System.out.println(">> on Write Error");
    }
}
