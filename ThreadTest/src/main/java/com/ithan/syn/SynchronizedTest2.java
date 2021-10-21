package com.ithan.syn;

    /*
        使用同步代码块解决线程安全问题
    */

    class Ticket2 implements Runnable{
        private int ticket = 100;
        //定义同步监视器（任何类的对象皆可）
        private Object obj = new Object();
        @Override
        public void run() {
            while (true)
            {
                //Object obj = new Object(); 错误，多个线程必须同用一把锁
                //synchronized(new Object()) 错误
                synchronized(this)
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
                    }else
                    {
                        break;
                    }
                }
            }
        }
    }


    public class SynchronizedTest2 {
        public static void main(String[] args) {
            Ticket3 ticket = new Ticket3();
            new Thread(ticket).start();
            new Thread(ticket).start();
            new Thread(ticket).start();
        }
    }
