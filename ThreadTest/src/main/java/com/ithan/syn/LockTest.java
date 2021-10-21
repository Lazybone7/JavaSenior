package com.ithan.syn;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

    /*
        LOCK锁
     */
    public class LockTest {
        private static int ticket = 100;
        static Lock lock = new ReentrantLock(true);
        public static void main(String[] args) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    show();
                }
            }).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    show();
                }
            }).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    show();
                }
            }).start();
        }

        private static void show()
        {
            while (true)
            {

                try {
                    lock.lock();
                    Thread.sleep(100);
                    if (ticket > 0)
                    {
                        System.out.println(Thread.currentThread().getName() + " 抢到了票号" + ticket);
                        ticket --;
                    }
                    else
                    {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
