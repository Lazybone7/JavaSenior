package com.ithan.syn;
/*
    同步方法解决线程安全问题（继承方式）
 */
class Ticket5 extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true)
        {
            show();
        }
    }

    private static synchronized void show() //同步监视器：Ticket5
    {
        if (ticket > 0)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了票号 " + ticket);
            ticket --;
        }
    }
}

public class SynchronizedTest4 {
    public static void main(String[] args) {
        Ticket5 t1 = new Ticket5();
        t1.start();
        Ticket5 t2 = new Ticket5();
        t2.start();
        Ticket5 t3 = new Ticket5();
        t3.start();
    }
}
