package com.dingjiajia.mall.search.thread;

public class ThreadTest {

    public static void main(String[] args) {
        /**
         * 1.继承 Thread
         * 2.实现 Runnable 接口
         * 3.实现 Callable 接口 + FutureTask
         * 4.线程池
         */

        System.out.println("main  ------ start -------");
        Thread01 thread = new Thread01();
        thread.start();
    }


    public static class Thread01 extends Thread{
        @Override
        public void run() {
            System.out.println("当前线程："+Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果："+i);
        }
    }
}
