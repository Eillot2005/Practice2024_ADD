public class Main {
    public static void main(String[] args) {
        new SpellingWordFrame();
    }
}

//实验练习：增加用户移动字母次数的功能，即当用户拼写成功后，messageLabel显示移动字母的次数。
/*
public class Main {
    public static void main(String[] args) {
        new SpellingWordFrame();
    }
}
在SpellingWordFrame类中增加一个变量count，用于记录用户移动字母的次数，初始值为0。
代码如下：
int count=0;
在keyPressed方法中，当用户按下左右方向键时，count加1。
代码如下：
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
在keyReleased方法中，当用户拼写成功后，messageLabel显示“恭喜你，你成功了,总共移动”+count+“次”。
代码如下：
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
 */