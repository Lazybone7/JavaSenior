package com.ithan.create;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/*
    实现Callable接口创建线程
 */
class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadCallable {
    public static void main(String[] args) {
        NumThread nt = new NumThread();
        FutureTask ft = new FutureTask(nt);
        new Thread(ft).start();

        try {
            Object o = ft.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
