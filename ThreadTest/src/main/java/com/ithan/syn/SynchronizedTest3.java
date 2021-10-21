package com.ithan.syn;

/*
    使用同步方法解决线程安全问题
*/

class Ticket3 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true)
        {
            show();
            if (ticket <= 0)
            {
                break;
            }
        }
    }

    private synchronized void show()
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


public class SynchronizedTest3 {
    public static void main(String[] args) {
        Ticket3 ticket = new Ticket3();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
