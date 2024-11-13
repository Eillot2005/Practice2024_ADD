import java.time.LocalDate;

public class GiveCalendar {
    public LocalDate[] getCalendar(LocalDate date){
        date=date.withDayOfMonth(1);
        int days=date.lengthOfMonth();
        LocalDate[] dateArray=new LocalDate[days];
        for(int i=0;i<days;i++){
            dateArray[i]=date.plusDays(i);
        }
        return dateArray;
    }
}
