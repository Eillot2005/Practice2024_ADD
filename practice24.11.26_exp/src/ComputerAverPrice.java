import java.sql.*;

public class ComputerAverPrice {
    public static void main(String[] args) {
        Connection con = null;
        Statement sql;
        ResultSet rs;
        //连接sqlserver数据库
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("数据库驱动加载成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JavaDb;trustServerCertificate=true", "sa", "abc");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try{
            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=sql.executeQuery("select * from bookList");
            rs.last();//移到最后一行
            int max=rs.getRow();//得到当前行号，也就是记录数
            System.out.println("表中有"+max+"条记录,随机抽取10条记录");
            int []a=RandomGetRecord.getRandomNumber(max,10);//调用RandomGetRecord类的getRandomNumber方法
            float sum=0;
            for(int i:a){//遍历数组
                rs.absolute(i+1);//将光标移动到指定行
                float price=rs.getFloat(3);//获取指定列的值
                sum+=price;//累加
            }
            con.close();
            System.out.println("平均价格为："+sum/10);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
