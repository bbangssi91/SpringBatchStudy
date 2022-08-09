package com.example.springbatchstudy;

public class CustomService<T> {

    private int count = 0;

    public T customRead(){
        return (T)("item = " + count++);
    }

}
