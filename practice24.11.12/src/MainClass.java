public class MainClass {
    public static void main(String[] args) {
        ComputerFrame frame;
        frame = new ComputerFrame();
        frame.setTitle("算术测试");
        frame.setBounds(100, 100, 650, 180);
    }
}

//1.模仿本实验再添加一个"小学生级别"
/*
在ComputerFrame类中添加一个JMenuItem对象grade3，然后添加一个ActionListener对象，当grade3被点击时，调用teacherZhang.setMaxInterger(100)方法。
JMenuItem grade3;
grade3 = new JMenuItem("小学生级别");
grade3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacherZhang.setMaxInterger(100);
            }
        });
*/

//给上述程序增加测试乘法的功能
/*
if (d <= 0.4) {
   operator = "+";
} else if(d <= 0.7) {
   operator = "-";
} else {
   operator = "*";
}

else if(operator.equals("*")) {
  if(result==numberOne*numberTwo) {
     message.setText("你回答正确");
  }
  else {
     message.setText("你回答错误");
  }
}
*/

