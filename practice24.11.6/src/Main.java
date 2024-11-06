public class Main {
    public static void main(String[] args) {
        //进程与线程
        /*
        进程是程序的一次执行过程，是一个动态的概念，是程序在执行过程中分配和管理资源的基本单位。
        线程是进程的一个实体，是CPU调度和分派的基本单位，是比进程更小的独立运行的基本单位。
         */
        //主线程
        /*
        主线程是程序的入口，是程序开始执行的地方，是程序的主要执行线程。
        主线程执行完毕，程序就结束了。
         */
        //创建线程
        /*
        1.继承Thread类
        2.实现Runnable接口
        3.使用匿名内部类
        4.使用Lambda表达式
         */
        //继承Thread类
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();

        //线程的生命周期
        /*
        1.新建状态
        2.就绪状态
        3.运行状态
        4.阻塞状态
        5.死亡状态
         */

        //常用方法
        /*
        1.start()：启动线程，调用run()方法
        2.run()：线程的主体，线程的执行体
        3.sleep()：线程休眠，让线程休眠一段时间
        4.join()：等待线程终止
        5.yield()：让出CPU
        6.interrupt()：中断线程
        7.isInterrupted()：判断线程是否中断
        8.setDaemon()：设置线程为守护线程
        9.stop()：停止线程
        10.wait()：等待线程
        11.notify()：唤醒线程
        12.notifyAll()：唤醒所有线程
         */

        //线程的同步
        /*
        1使用synchronized关键字修饰方法
         */

    }
    //继承Thread类
    static class MyThread1 extends Thread{
        @Override
        public void run() {
            for(int i = 0;i < 10;i++){
                System.out.println("子线程1：" + i);
            }
        }
    }
    static class MyThread2 extends Thread{
        @Override
        public void run() {
            for(int i = 0;i < 10;i++){
                System.out.println("子线程2：" + i);
            }
        }
    }
}