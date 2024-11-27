import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreeThreadGuessNumberGUI {
    private volatile int numberToGuess; // 要猜的数字
    private volatile boolean guessedCorrectly = false; // 是否猜对
    private volatile int lowerBound = 1; // 当前猜测范围的下界
    private volatile int upperBound = 1000000; // 当前猜测范围的上界
    private volatile boolean isHigherThreadTurn = true; // 当前是否轮到“猜大”线程运行
    private final Object lock = new Object(); // 锁对象，用于线程间通信
    Random random = new Random();

    // GUI 组件
    private JFrame frame;
    private JTextArea logArea;
    private JLabel numberLabel;

    public ThreeThreadGuessNumberGUI() {
        setupGUI();
        giveNumberThread.start();
        guessHigherThread.start();
        guessLowerThread.start();
    }

    // 设置 GUI
    private void setupGUI() {
        frame = new JFrame("三线程猜数字");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        numberLabel = new JLabel("正在生成数字...", SwingConstants.CENTER);
        numberLabel.setFont(new Font("隶书", Font.BOLD, 40));
        //字体有：微软雅黑、宋体、黑体、楷体、隶书、幼圆
        frame.add(numberLabel, BorderLayout.NORTH);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        logArea.setFont(new Font("宋体", Font.PLAIN, 16));
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // 更新日志
    private void updateLog(String message) {
        //停止一秒钟
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
    }

    // 更新目标数字显示
    private void updateNumberLabel(String message) {
        SwingUtilities.invokeLater(() -> numberLabel.setText(message));
    }

    // 线程负责生成随机数字
    Thread giveNumberThread = new Thread(() -> {
        synchronized (lock) { // 保证线程安全,只有一个线程能够执行
            numberToGuess = random.nextInt(1000000) + 1; // 生成1-100的随机数
            updateNumberLabel("你要猜的数字是：?");
            updateLog("目标数字已生成！开始猜数字。");
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
                updateLog("刚刚猜小了，现在我往大了猜: " + guess);
                if (guess < numberToGuess) {
                    updateNumberLabel(guess+"<"+numberToGuess);
                    lowerBound = guess + 1; // 缩小范围
                } else if (guess == numberToGuess) {
                    guessedCorrectly = true;
                    updateLog("我这次往大了猜，猜对了: " + numberToGuess);
                    updateNumberLabel("猜对了！数字是：" + numberToGuess);
                } else {
                    updateNumberLabel(guess+">"+numberToGuess);
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
                updateLog("刚刚猜大了，现在我往小了猜: " + guess);
                if (guess > numberToGuess) {
                    updateNumberLabel(guess+">"+numberToGuess);
                    upperBound = guess - 1; // 缩小范围
                } else if (guess == numberToGuess) {
                    guessedCorrectly = true;
                    updateLog("我这次往小了猜，猜对了: " + numberToGuess);
                    updateNumberLabel("猜对了！数字是：" + numberToGuess);
                } else {
                    updateNumberLabel(guess+"<"+numberToGuess);
                    lowerBound = guess + 1; // 缩小范围
                    isHigherThreadTurn = true; // 切换到“猜大”线程
                    lock.notifyAll(); // 通知其他线程
                }
            }
        }
    });

    // 主方法
    public static void main(String[] args) {
        new Number2();
    }
}