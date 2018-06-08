package com.company;

public class Main {

    public static class MyLock{
        private volatile Integer orderNum;

        public MyLock(Integer orderNum) {
            this.orderNum = orderNum;
        }
    }

    public static class Worker implements Runnable{
        private MyLock myLock;
        private Integer num;
        public Worker(MyLock myLock,Integer num) {
            this.myLock = myLock;
            this.num = num;
        }

        @Override
        public void run() {
            synchronized (myLock){
                while(!myLock.orderNum.equals(num)){
                    try {
                        myLock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(myLock.orderNum++);
                myLock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyLock myLock = new MyLock(0);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker(myLock,i);
            threads[i]  = new Thread(worker);
            threads[i].start();
        }

        Thread.currentThread().sleep(100);

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("done");
    }
}
