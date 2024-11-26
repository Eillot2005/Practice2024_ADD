import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpellingWordFrame extends JFrame implements KeyListener,ActionListener {
    JTextField inputWord;
    JButton button;
    LetterLabel label[];
    JPanel northP,centerP;
    Box wordBox;
    String hintMessage="用鼠标单击字母，按左右箭头交换字母，将其排列成所输入的单词";
    JLabel messageLabel=new JLabel(hintMessage);
    String word="";
    SpellingWordFrame(){
        inputWord=new JTextField(12);
        button=new JButton("确定");
        button.addActionListener(this);
        inputWord.addActionListener(this);
        northP=new JPanel();
        northP.add(new JLabel("输入单词:"));
        northP.add(inputWord);
        northP.add(button);
        centerP=new JPanel();
        wordBox=Box.createHorizontalBox();
        centerP.add(wordBox);
        add(northP, BorderLayout.NORTH);
        add(centerP,BorderLayout.CENTER);
        add(messageLabel,BorderLayout.SOUTH);
        setBounds(100,100,450,180);
        setVisible(true);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        word=inputWord.getText();
        int n=word.length();
        RondomString rondom=new RondomString();
        String randomWord=rondom.getRondomString(word);
        wordBox.removeAll();
        messageLabel.setText(hintMessage);
        if (n>0){
            label=LetterLabel.getLetterLabel(n);
            for (int k=0;k<label.length;k++){
                label[k].setText(""+randomWord.charAt(k));
                wordBox.add(label[k]);
                label[k].addKeyListener(this);
            }
            validate();
            inputWord.setText(null);
            label[0].requestFocus();
        }
    }
    int count=0;
    public void keyPressed(KeyEvent e){
        LetterLabel sourceLabel=(LetterLabel)e.getSource();
        int index=-1;
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            count++;
            for (int k=0;k<label.length;k++){
                if(label[k]==sourceLabel){
                    index=k;
                    break;
                }
            }
            if(index!=0){
                String temp=label[index].getText();
                label[index].setText(label[index-1].getText());
                label[index-1].setText(temp);
                label[index-1].requestFocus();
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            count++;
            for(int k=0;k<label.length;k++){
                if(label[k]==sourceLabel) {
                    index = k;
                    break;
                }
            }
            if(index!=label.length-1){
                String temp=label[index].getText();
                label[index].setText(label[index+1].getText());
                label[index+1].setText(temp);
                label[index+1].requestFocus();
            }
        }
        validate();
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){
        String success="";
        for (int k=0;k<label.length;k++){
            String str=label[k].getText();
            success+=str;
        }
        if (success.equals(word)){
            messageLabel.setText("恭喜你，你成功了,总共移动"+count+"次");
            count=0;
            for (int k=0;k<label.length;k++){
                label[k].removeKeyListener(this);
                label[k].removeFocusListener(label[k]);
                label[k].setBackground(Color.white);
            }
            inputWord.requestFocus();
        }
    }
}
