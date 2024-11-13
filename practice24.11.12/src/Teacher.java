import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Teacher implements ActionListener{
    int numberOne, numberTwo;
    String operator="";
    boolean isRight;
    Random random;
    int maxInterger;
    JTextField textOne, textTwo, textResult;
    JLabel operatorLabel1,message;
    Teacher() {
        random = new Random();
    }
    public void setMaxInterger(int maxInterger) {
        this.maxInterger = maxInterger;
    }
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        if(str.equals("getProblem")) {
            numberOne = random.nextInt(maxInterger) + 1;
            numberTwo = random.nextInt(maxInterger) + 1;
            double d = Math.random();
            if (d <= 0.4) {
                operator = "+";
            } else if(d <= 0.7) {
                operator = "-";
            } else {
                operator = "*";
            }
            textOne.setText("" + numberOne);
            textTwo.setText("" + numberTwo);
            operatorLabel1.setText(operator);
            message.setText("请回答");
            textResult.setText(null);
        }
        else if(str.equals("Answer")) {
            String answer=textResult.getText();
            try{int result=Integer.parseInt(answer);
                if(operator.equals("+")) {
                    if(result==numberOne+numberTwo) {
                        message.setText("你回答正确");
                    }
                    else {
                        message.setText("你回答错误");
                    }
                }
                else if(operator.equals("-")) {
                    if(result==numberOne-numberTwo) {
                        message.setText("你回答正确");
                    }
                    else {
                        message.setText("你回答错误");
                    }
                }
                else if(operator.equals("*")) {
                    if(result==numberOne*numberTwo) {
                        message.setText("你回答正确");
                    }
                    else {
                        message.setText("你回答错误");
                    }
                }
            }
            catch(NumberFormatException ex) {
                message.setText("请输入数字字符");
            }
        }
    }
    public void setJTextField(JTextField ...t) {
        textOne = t[0];
        textTwo = t[1];
        textResult = t[2];
    }
    public void setJLabel(JLabel ...label) {
        operatorLabel1 = label[0];
        message = label[1];
    }
}
