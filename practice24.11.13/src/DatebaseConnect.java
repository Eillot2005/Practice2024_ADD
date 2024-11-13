import java.sql.DriverManager;

public class DatebaseConnect {
    //连接本机数据库SQL Server
    public static void main(String[] args) {
        try {
            //加载数据库驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //创建数据库连接
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Master;encrypt=false;user=yourUsername;password=yourPassword";
            String user = "sa";
            String password = "abc";
            DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
