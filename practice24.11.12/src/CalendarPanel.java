import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarPanel extends JPanel {
    GiveCalendar calendar;
    LocalDate[] dateArrays;
    public LocalDate currentDate;
    String name[]= {"日","一","二","三","四","五","六"};
    public CalendarPanel(){
        calendar=new GiveCalendar();
        currentDate=LocalDate.now();
        dateArrays=calendar.getCalendar(currentDate);
        showCalendar(dateArrays);
    }
    public void showCalendar(LocalDate[] dateArray){
        removeAll();
        GridLayout gridLayout=new GridLayout(7,7);
        //代码1:将当前容器的布局管理器设置为gridLayout
        setLayout(gridLayout);
        JLabel[] titleWeek=new JLabel[7];
        JLabel[] showDate=new JLabel[42];
        for(int i=0;i<7;i++){
            titleWeek[i]=new JLabel(name[i],JLabel.CENTER);
            //代码2:将组件titleWeek[i]添加到当前容器
            add(titleWeek[i]);
        }
        for(int i=0;i<42;i++){
            showDate[i]=new JLabel("",JLabel.CENTER);
        }
        for(int k=7,i=0;k<49;k++,i++){
            add(showDate[i]);
        }
        int space=printSpace(dateArray[0].getDayOfWeek());
        for(int i=0,j=space+i;i<dateArray.length;i++,j++){
            showDate[j].setText(""+dateArray[i].getDayOfMonth());
        }
        repaint();
    }
    public void setNext()
    {
        currentDate=currentDate.plusMonths(1);
        dateArrays=calendar.getCalendar(currentDate);
        showCalendar(dateArrays);
    }
    public void setPrevious()
    {
        currentDate=currentDate.plusMonths(-1);
        dateArrays=calendar.getCalendar(currentDate);
        showCalendar(dateArrays);
    }
    public int printSpace(DayOfWeek x){
        int n=0;
        switch (x) {
            case SUNDAY:
                n = 0;
                break;
            case MONDAY:
                n = 1;
                break;
            case TUESDAY:
                n = 2;
                break;
            case WEDNESDAY:
                n = 3;
                break;
            case THURSDAY:
                n = 4;
                break;
            case FRIDAY:
                n = 5;
                break;
            case SATURDAY:
                n = 6;
                break;
        }
        return n;
    }
}
