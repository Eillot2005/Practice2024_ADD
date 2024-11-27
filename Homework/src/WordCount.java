import java.awt.*;
import javax.swing.*;
public class WordCount {
    public static void main(String[] args) {
        //使用GUI界面进行单词统计
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("请输入文本:");//标签
        //创建一个大的输入框
        JTextArea textField = new JTextArea(10, 30);
        textField.setLineWrap(true);
        JButton button = new JButton("统计");
        JLabel label1 = new JLabel("单词数:");
        TextField textField1 = new TextField(20);
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(label1);
        frame.add(textField1);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(e -> {
            String text = textField.getText();
            String[] words = text.split("\\s+");//以空格为分隔符
            textField1.setText(String.valueOf(words.length));
        });
    }
}
