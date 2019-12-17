package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // класс - Thread
        // интерфейс Runnable
        // synchronized
        // join
        // notify
        // wait
        // sleep
        // start

        MyThread t1 = new MyThread("+");
        MyThread t2 = new MyThread("-");
        t1.start();
        t2.start();
        Thread.sleep(4000);
        t1.flag = false;
        t1.join(); // ждет завершение 1-го потока
        Main.test("1 stopped!");
    }
    public static Object monitor = new Object();
    public  static void test(String m) {
        try {
            synchronized(monitor) {
                System.out.print("[");
                Thread.sleep(1000);
                System.out.print(m);
                Thread.sleep(1000);
                System.out.print("]");
               // monitor.notify(); // возобн. поток в сост-ии wait
               // monitor.wait(); // переходит в сост-ие ожидания вызова notify
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
