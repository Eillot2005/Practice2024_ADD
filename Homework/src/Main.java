import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //创建四个窗口，分别是红、黄、蓝、绿
        JFrame frame1 = new JFrame("1");
        JFrame frame2 = new JFrame("2");
        JFrame frame3 = new JFrame("3");
        JFrame frame4 = new JFrame("4");
        //设置窗口的大小和位置
        frame1.setBounds(100, 100, 200, 200);
        frame2.setBounds(300, 100, 200, 200);
        frame3.setBounds(100, 300, 200, 200);
        frame4.setBounds(300, 300, 200, 200);
        //设置窗口可见
        frame1.setVisible(true);
        frame2.setVisible(true);
        frame3.setVisible(true);
        frame4.setVisible(true);
        //设置窗口的背景颜色
        frame1.getContentPane().setBackground(Color.red);
        frame2.getContentPane().setBackground(Color.yellow);
        frame3.getContentPane().setBackground(Color.blue);
        frame4.getContentPane().setBackground(Color.green);
        //设置窗口的关闭方式
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}