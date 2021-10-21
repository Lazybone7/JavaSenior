package com.ithan.create;

class MyThread implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + "print" + i);
            }
        }
    }
}

public class ThreadRunnable {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}
