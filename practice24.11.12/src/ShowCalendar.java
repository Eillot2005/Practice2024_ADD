import javax.swing.*;

public class ShowCalendar extends JFrame {
    CalendarPanel showCalendar;
    JButton nextMonth;
    JButton previousMonth;
    JLabel showYear, showMonth;
    public ShowCalendar() {
        showCalendar = new CalendarPanel();
        add(showCalendar);
        nextMonth = new JButton("下一个月");
        previousMonth = new JButton("上一个月");
        showYear=new JLabel();
        showMonth=new JLabel();
        JPanel pNorth=new JPanel();
        JPanel pSouth=new JPanel();
        showYear.setText(""+showCalendar.currentDate.getYear()+"年");
        showMonth.setText(""+showCalendar.currentDate.getMonthValue()+"月");
        //pNorth.add(showYear);
        pSouth.add(showYear);
        pNorth.add(previousMonth);
        pNorth.add(nextMonth);
        //pNorth.add(showMonth);
        pSouth.add(showMonth);
        //代码3:将pNorth添加到窗口的North位置
        add(pNorth,"North");
        add(pSouth,"South");
        nextMonth.addActionListener((e)->{
            showCalendar.setNext();
            showYear.setText(""+showCalendar.currentDate.getYear()+"年");
            showMonth.setText(""+showCalendar.currentDate.getMonthValue()+"月");
        });
        previousMonth.addActionListener((e)->{
            showCalendar.setPrevious();
            showYear.setText(""+showCalendar.currentDate.getYear()+"年");
            showMonth.setText(""+showCalendar.currentDate.getMonthValue()+"月");
        });
        setSize(290,260);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ShowCalendar();
    }
}

//1.在ShowCalendar窗口的SOUTH区域显示日历上的年份和月份
/*
将
JPanel pNorth=new JPanel();
pNorth.add(showYear);
pNorth.add(previousMonth);
pNorth.add(nextMonth);
pNorth.add(showMonth);
add(pNorth,"North");
改为
JPanel pNorth=new JPanel();
JPanel PSouth=new JPanel();
pSouth.add(showYear);
pNorth.add(previousMonth);
pNorth.add(nextMonth);
pSouth.add(showMonth);
add(pNorth,"North");
add(pSouth,"South");
*/