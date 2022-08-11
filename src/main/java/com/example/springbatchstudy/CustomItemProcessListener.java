package com.example.springbatchstudy;

import org.springframework.batch.core.ItemProcessListener;

public class CustomItemProcessListener implements ItemProcessListener<Integer, String> {

    @Override
    public void beforeProcess(Integer integer) {
        System.out.println(">> Before Process");
    }

    @Override
    public void afterProcess(Integer integer, String s) {
        System.out.println(">> After Process");
    }

    @Override
    public void onProcessError(Integer integer, Exception e) {
        System.out.println(">> On Process Error");
    }

}
