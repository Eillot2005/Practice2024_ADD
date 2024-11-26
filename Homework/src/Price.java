import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Price {
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("价格计算器");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建组件
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton fetchButton = new JButton("获取");
        JButton calculateButton = new JButton("计算");
        JTextField resultField = new JTextField();

        // 布局
        frame.setLayout(null);
        scrollPane.setBounds(20, 20, 440, 200);
        fetchButton.setBounds(20, 240, 100, 30);
        calculateButton.setBounds(140, 240, 100, 30);
        resultField.setBounds(20, 290, 440, 30);

        frame.add(scrollPane);
        frame.add(fetchButton);
        frame.add(calculateButton);
        frame.add(resultField);

        // 事件处理：获取文件内容
        fetchButton.addActionListener(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("data.txt")))
            {
                String line;
                // 读取文件内容
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "文件读取失败！");
            }
        });

        // 事件处理：计算平均价格
        calculateButton.addActionListener(e -> {
            try {
                // 读取文本框内容
                String[] lines = textArea.getText().split("\n");// 以换行符分割
                ArrayList<Integer> prices = new ArrayList<>();
                for (String line : lines) {
                    // 包含“元/台”的行
                    if (line.contains("元/台")) {
                        String[] parts = line.split(",");// 以逗号分割
                        String priceStr = parts[1].replaceAll("[^0-9]", "");// 只保留数字
                        prices.add(Integer.parseInt(priceStr));
                    }
                }
                // 计算总价格
                int total = 0;
                for (int price : prices) {
                    total += price;
                }
                resultField.setText("总价：" + total + "元");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "计算失败！");
            }
        });

        // 显示窗口
        frame.setVisible(true);
    }
}

