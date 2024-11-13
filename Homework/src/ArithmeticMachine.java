import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ArithmeticMachine {
    private double result = 0; // 当前计算结果
    private String lastOperator = ""; // 上一个运算符
    private boolean isOperatorClicked = false; // 检查是否点击了运算符
    private final JTextField display = new JTextField();
    public ArithmeticMachine() {
        // 创建框架
        JFrame frame = new JFrame("简易计算器");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        // 显示框
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));// 设置字体
        display.setHorizontalAlignment(SwingConstants.RIGHT);// 右对齐
        frame.add(display, BorderLayout.NORTH);// 添加到框架的上方
        // 按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        String[] buttonLabels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "C", "0", "=", "/"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));// 设置字体
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("\\d")) { // 检查是否为数字，语句中的\d是正则表达式中的特殊字符，需要转义
                if (isOperatorClicked) {
                    display.setText(command);
                    isOperatorClicked = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else if (command.matches("[+\\-*/]")) { // 检查是否为运算符，语句中的+、-、*、/是正则表达式中的特殊字符，需要转义
                if (!display.getText().isEmpty()) {
                    if (!lastOperator.isEmpty()) {
                        calculate(Double.parseDouble(display.getText()));
                        display.setText(String.valueOf(result));
                    } else {
                        result = Double.parseDouble(display.getText());
                    }
                    lastOperator = command;
                    isOperatorClicked = true;
                }
            } else if (command.equals("=")) { // 计算结果
                if (!lastOperator.isEmpty() && !display.getText().isEmpty()) {
                    calculate(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    lastOperator = "";
                }
            } else if (command.equals("C")) { // 清空操作
                result = 0;
                lastOperator = "";
                display.setText("");
            }
        }
        private void calculate(double secondOperand) {
            switch (lastOperator) {
                case "+":
                    result += secondOperand;
                    break;
                case "-":
                    result -= secondOperand;
                    break;
                case "*":
                    result *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result /= secondOperand;
                    } else {
                        JOptionPane.showMessageDialog(null, "除数不能为零");
                        result = 0; // 重置结果
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArithmeticMachine::new);
    }
}


