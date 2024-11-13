import java.time.LocalDate;
public class calendar {
    public static void main(String[] args) {
        //输出当前机器当前日期中月份的日历
        //获取当前日期
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        //获取当前月份的第一天
        LocalDate cal = LocalDate.of(year, month, 1);
        //获取当前月份的第一天是星期几
        int week = cal.getDayOfWeek().getValue();
        //输出日历
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        //输出第一天之前的空格
        for (int i = 0; i < week; i++) {
            System.out.print("\t");
        }
        while (cal.getMonthValue() == month) {
            System.out.print(cal.getDayOfMonth() + "\t");
            if (cal.getDayOfWeek().getValue() == 6) {
                System.out.println();
            }
            cal = cal.plusDays(1);
        }
    }
}
