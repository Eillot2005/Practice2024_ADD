
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerFrame extends JFrame {
    JMenuBar menubar;
    JMenu choiceGrade;
    JMenuItem grade1, grade2;
    JMenuItem grade3;
    JTextField textOne, textTwo, textResult;
    JButton getProblem, giveAnswer;
    JLabel operatorLabel1,message;
    Teacher teacherZhang;
    ComputerFrame() {
        teacherZhang = new Teacher();
        teacherZhang.setMaxInterger(20);
        setLayout(new FlowLayout());
        menubar = new JMenuBar();
        choiceGrade = new JMenu("选择级别");
        grade1 = new JMenuItem("幼儿级别");
        grade2 = new JMenuItem("儿童级别");
        grade3 = new JMenuItem("小学生级别");
        grade1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacherZhang.setMaxInterger(10);
            }
        });
        grade2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacherZhang.setMaxInterger(50);
            }
        });
        grade3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacherZhang.setMaxInterger(100);
            }
        });
        choiceGrade.add(grade1);
        choiceGrade.add(grade2);
        choiceGrade.add(grade3);
        menubar.add(choiceGrade);
        setJMenuBar(menubar);
        //代码1:创建textOne,其可见字符长5
        textOne = new JTextField(5);
        textTwo = new JTextField(5);
        textResult=new JTextField(5);
        operatorLabel1 = new JLabel("+");
        operatorLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        message=new JLabel("你还没有回答我呢");
        getProblem = new JButton("获取题目");
        giveAnswer = new JButton("确认答案");
        add(getProblem);
        add(textOne);
        add(operatorLabel1);
        add(textTwo);
        add(new JLabel("="));
        add(textResult);
        add(giveAnswer);
        add(message);
        textResult.requestFocus();
        textOne.setEditable(false);
        textTwo.setEditable(false);
        getProblem.setActionCommand("getProblem");
        textResult.setActionCommand("Answer");
        giveAnswer.setActionCommand("Answer");
        teacherZhang.setJTextField(textOne, textTwo, textResult);
        teacherZhang.setJLabel(operatorLabel1,message);
        //代码2:将teacherZhang注册为getProblem的ActionListener
        getProblem.addActionListener(teacherZhang);
        //代码3:将teacherZhang注册为giveAnswer的ActionListener
        giveAnswer.addActionListener(teacherZhang);
        //代码4:将teacherZhang注册为textResult的ActionListener
        textResult.addActionListener(teacherZhang);
        setVisible(true);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
