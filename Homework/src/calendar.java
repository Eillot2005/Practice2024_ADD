import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class calendar {
    private static LocalDate currentDate = LocalDate.now();
    private static JTable table;
    private static JFrame frame;

    public static void main(String[] args) {
        // 创建窗口
        frame = new JFrame(currentDate.getYear() + "年" + currentDate.getMonthValue() + "月");
        frame.setBounds(100, 100, 400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 创建表格
        table = new JTable();
        updateCalendar();

        // 创建按钮
        JButton prevButton = new JButton("上个月");
        JButton nextButton = new JButton("下个月");
        JButton todayButton = new JButton("回到今天");

        // 添加按钮事件
        // 上个月
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDate = currentDate.minusMonths(1);
                updateCalendar();
            }
        });

        // 下个月
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDate = currentDate.plusMonths(1);
                updateCalendar();
            }
        });

        // 回到今天
        todayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDate = LocalDate.now();
                updateCalendar();
            }
        });

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(todayButton);

        // 添加组件到窗口
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void updateCalendar() {
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int today = currentDate.getDayOfMonth();

        // 获取当前月份的第一天
        LocalDate cal = LocalDate.of(year, month, 1);
        int week = cal.getDayOfWeek().getValue();

        // 表头
        String[] columnNames = {"一", "二", "三", "四", "五", "六", "日"};
        // 表格数据
        Object[][] data = new Object[6][7];
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < week - 1) {
                    data[i][j] = "";
                } else if (day <= cal.lengthOfMonth()) {
                    data[i][j] = day;
                    day++;
                } else {
                    data[i][j] = "";
                }
            }
        }

        // 更新表格数据
        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 20));
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        table.setEnabled(false);

        // 更新窗口标题
        frame.setTitle(year + "年" + month + "月");
    }
}
