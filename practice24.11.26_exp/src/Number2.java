//一个线程用来处理猜大，一个用来处理猜小，一个用来猜对(根据ThreeThread.java修改)

import java.util.Random;

public class Number2 {
    private volatile int numberToGuess; // 要猜的数字
    private volatile boolean guessedCorrectly = false; // 是否猜对
    private volatile int lowerBound = 1; // 当前猜测范围的下界
    private volatile int upperBound = 100; // 当前猜测范围的上界
    private volatile boolean isHigherThreadTurn = true; // 当前是否轮到“猜大”线程运行
    private final Object lock = new Object(); // 锁对象，用于线程间通信
    Random random = new Random();
    public Number2() {
        giveNumberThread.start();
        guessHigherThread.start();
        guessLowerThread.start();
    }
    // 线程负责生成随机数字
    Thread giveNumberThread = new Thread(() -> {
        synchronized (lock) {// 保证线程安全,只有一个线程能够执行
            numberToGuess = random.nextInt(100) + 1; // 生成1-100的随机数
            System.out.println("你要猜的是: " + numberToGuess);
            lock.notifyAll(); // 通知其他线程开始猜测
        }
    });

    // 线程负责“猜大”的逻辑
    Thread guessHigherThread = new Thread(() -> {
        while (!guessedCorrectly) {
            synchronized (lock) {
                while (!isHigherThreadTurn && !guessedCorrectly) {
                    try {
                        lock.wait(); // 等待轮到自己猜
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (guessedCorrectly) break; // 如果已经猜对，退出循环
                int guess = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // 从当前范围内随机猜
                System.out.println("刚刚猜小了，现在我往大了猜: " + guess);
                if (guess < numberToGuess) {
                    lowerBound = guess + 1; // 缩小范围
                } else if (guess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("我这次往大了猜，猜对了: " + numberToGuess);
                }
                else {
                    upperBound = guess - 1; // 缩小范围
                    isHigherThreadTurn = false; // 切换到“猜小”线程
                    lock.notifyAll(); // 通知其他线程
                }
            }
        }
    });

    // 线程负责“猜小”的逻辑
    Thread guessLowerThread = new Thread(() -> {
        while (!guessedCorrectly) {
            synchronized (lock) {
                while (isHigherThreadTurn && !guessedCorrectly) {
                    try {
                        lock.wait(); // 等待轮到自己猜
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (guessedCorrectly) break; // 如果已经猜对，退出循环
                int guess = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // 从当前范围内随机猜
                System.out.println("刚刚猜大了，现在我往小了猜: " + guess);
                if (guess > numberToGuess) {
                    upperBound = guess - 1; // 缩小范围
                } else if (guess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("我这次往小了猜，猜对了: " + numberToGuess);
                } else {
                    lowerBound = guess + 1; // 缩小范围
                    isHigherThreadTurn = true; // 切换到“猜大”线程
                    lock.notifyAll(); // 通知其他线程
                }
            }
        }
    });
}


