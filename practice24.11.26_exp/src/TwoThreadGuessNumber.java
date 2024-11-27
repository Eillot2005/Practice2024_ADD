public class TwoThreadGuessNumber {
    public static void main(String[] args) {
        Number number = new Number();
        number.giveNumberThread.start();
        number.guessNumberThread.start();
    }
}

//如果是三线程，那么就是一个线程给出数字，两个线程猜数字，一个线程猜大，一个线程猜小，猜对了就结束
//代码如下：
/*
public class ThreeThreadGuessNumber {
    public static void main(String[] args) {
        Number number = new Number();
        number.giveNumberThread.start();
        number.guessNumberThread.start();
        number.guessNumberThread2.start();
    }
}
ThreeThreadGuessNumber.java

public class Number {
    boolean pleaseGuess = false, isGiveNumber = false;
    Thread giveNumberThread, guessNumberThread, guessNumberThread2;
    int realNumber, guessNumber, min = 1, max = 100;
    int message = 0;
    final int SMALLER = 1, LARGER = 2, SUCCESS = 3;

    Number() {
        giveNumberThread = new Thread(this);
        guessNumberThread = new Thread(this);
        guessNumberThread2 = new Thread(this);
    }

    public void run() {
        for (int count = 1; true; count++) {
            setMessage(count);
            if (message == SUCCESS) {
                return;
            }
        }
    }

    public synchronized void setMessage(int count) {
        if (Thread.currentThread() == giveNumberThread && isGiveNumber == false) {
            realNumber = (int) (Math.random() * 100) + 1;
            System.out.println("随机给你一个1-100的数，请猜测");
            isGiveNumber = true;
            pleaseGuess = true;
        }
        if (Thread.currentThread() == giveNumberThread) {
            while (pleaseGuess == true)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            if (realNumber > guessNumber) {
                message = SMALLER;
                System.out.println("猜小了");
            } else if (realNumber < guessNumber) {
                message = LARGER;
                System.out.println("猜大了");
            } else {
                message = SUCCESS;
                System.out.println("猜对了，猜了" + count + "次");
            }
            pleaseGuess = true;
        }
        if (Thread.currentThread() == guessNumberThread && isGiveNumber == true) {
            while (pleaseGuess == false)
                try {
                    wait();
                } catch (InterruptedException e) {
                }

            if (message == SMALLER) {
                min = guessNumber;
                guessNumber = (min + max) / 2;
                System.out.println("我第" + count + "次猜测的数字是" + guessNumber);
            } else if (message == LARGER) {
                max = guessNumber;
                guessNumber = (min + max) / 2;
                System.out.println("我第" + count + "次猜测的数字是" + guessNumber);
            }
            pleaseGuess = false;
        }
        if (Thread.currentThread() == guessNumberThread2 && isGiveNumber == true) {
            while (pleaseGuess == false)
                try {
                    wait();
                } catch (InterruptedException e) {
                }

            if (message == SMALLER) {
                min = guessNumber;
                guessNumber = (min + max) / 2;
                System.out.println("我第" + count + "次猜测的数字是" + guessNumber);
            } else if (message == LARGER) {
                max = guessNumber;
                guessNumber = (min + max) / 2;
                System.out.println("我第" + count + "次猜测的数字是" + guessNumber);
            }
            pleaseGuess = false;
        }
        notifyAll();
    }
}
 */