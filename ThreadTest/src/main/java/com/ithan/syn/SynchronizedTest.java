package com.ithan.syn;

/*
    存在线程安全问题
*/

class Ticket implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了票号 " + ticket--);
            if (ticket <= 0)
                break;
        }
    }
}



public class SynchronizedTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
