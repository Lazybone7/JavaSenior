package com.ithan.single;
/*
    线程安全的单例模式（懒汉式）
 */
public class Bank {
    private static Bank instance = null;

    private Bank(){

    }

//    private static synchronized Bank getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new Bank();
//        }
//        return instance;
//    }

    private static Bank getInstance()
    {
        //方式一：效率差
//        synchronized (Bank.class)
//        {
//            if (instance == null)
//            {
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二：双重检查
        if (instance == null)
        {
            synchronized (Bank.class)
            {
                if (instance == null)
                {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}

