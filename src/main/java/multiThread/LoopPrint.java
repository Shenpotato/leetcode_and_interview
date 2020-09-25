package multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoopPrint {

    private int status = 1;

    public void printA() {
        synchronized (this) {
            while (status != 1) {       // 不能使用if语句进行判断
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            status = 2;
            this.notifyAll();
        }
    }

    public void printB() {
        synchronized (this) {
            while (status != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            status = 1;
            this.notifyAll();
        }
    }

    static class ThreadOne implements Runnable {

        private LoopPrint loopPrint;

        public ThreadOne(LoopPrint loopPrint) {
            this.loopPrint = loopPrint;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                loopPrint.printA();
            }
        }
    }

    static class ThreadTwo implements Runnable{

        private LoopPrint loopPrint;

        public ThreadTwo(LoopPrint loopPrint){
            this.loopPrint = loopPrint;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                loopPrint.printB();
            }
        }
    }

    public static void main(String[] args) {
        LoopPrint loopPrint = new LoopPrint();
        ThreadOne threadOne = new ThreadOne(loopPrint);
        ThreadTwo threadTwo = new ThreadTwo(loopPrint);
        new Thread(threadOne, "ThreadOne").start();
        new Thread(threadTwo, "ThreadTwo").start();
    }

}
