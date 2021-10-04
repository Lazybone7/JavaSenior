# 多线程

## 关于线程需要注意的问题

1. 不能让已经start()的线程再次start();要想启动多个线程就要造多个对象

## 创建线程的方式

### 1. 继承Thread类,重写run方法

```java
Class MyThread extends Thread
{
    @override
    public void run()
    {
        //此线程需要执行的操作代码
        ...
        ...
	}
}

public ClassTest
{
    public static void main(String[] args)
    {
        //创建子类对象
        MyThread mt = new MyThread();
        //调用子类对象的start()方法
        mt.start();
	}
}

```



## 线程调度

**调度策略：**==时间片== 、==抢占式==

**调度方法：**	

- 同优先级采用**先进先出**，使用时间片策略。
- 高优先级采用**优先调度**的抢占策略。

### 线程优先级

```java
MAX_PRIORITY:	10
MIN_PRIORITY:	1
NORM_PRIORITY:	5
    
涉及方法：
    getPrioity()	//获取线程优先级
    setPrioity(int newPrioity)	//设置线程优先级
    
   
```

