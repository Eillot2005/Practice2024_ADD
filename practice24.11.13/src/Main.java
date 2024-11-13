public class Main {
    public static void main(String[] args) {
        //JDBC
        /*
        1. JDBC是什么?
          JDBC(Java Database Connectivity)是一种用于执行SQL语句的Java API,可以为多种关系数据库提供统一访问,它由一组类和接口组成。
        2. JDBC的工作原理是什么?
          JDBC的工作原理是通过JDBC API提供的接口,将SQL语句传递给数据库,并将数据库返回的结果传递给Java程序。
        3. JDBC的主要组成部分有哪些?
          JDBC的主要组成部分有:
          1. DriverManager:负责管理JDBC驱动程序,并根据数据库连接字符串选择合适的驱动程序。
          2. Connection:表示与数据库的连接,通过Connection对象可以创建Statement对象。
          3. Statement:用于执行SQL语句,可以执行查询、更新、删除等操作。
          4. ResultSet:表示查询结果集,通过ResultSet对象可以获取查询结果。
          5. PreparedStatement:继承自Statement,用于执行预编译的SQL语句。
          6. CallableStatement:继承自PreparedStatement,用于执行存储过程。
          7. ResultSetMetaData:用于获取ResultSet的元数据信息。
          8. DatabaseMetaData:用于获取数据库的元数据信息。
        4. JDBC的使用步骤是什么?
          JDBC的使用步骤是:
          1. 加载数据库驱动程序。
          2. 创建数据库连接。
          3. 创建Statement对象。
          4. 执行SQL语句。
          5. 处理查询结果。
          6. 关闭数据库连接。
        5. JDBC的连接方式有哪些?
          JDBC的连接方式有:
          1. DriverManager.getConnection(url, user, password):通过DriverManager获取数据库连接。
          2. DataSource.getConnection():通过DataSource获取数据库连接。
        6. JDBC的事务处理是什么?
          JDBC的事务处理是通过Connection对象的setAutoCommit()方法设置是否自动提交事务,通过commit()方法提交事务,通过rollback()方法回滚事务。
        7. JDBC的异常处理是什么?
          JDBC的异常处理是通过try-catch语句捕获SQLException异常,并在finally块中关闭数据库连接。
        8. JDBC的批处理是什么?
          JDBC的批处理是通过addBatch()方法将多条SQL语句添加到批处理中,然后通过executeBatch()方法一次性执行所有SQL语句。
        9. JDBC的元数据是什么?
          JDBC的元数据是用于描述数据库结构的信息,包括表名、列名、数据类型等。
        10. JDBC的预编译是什么?
         */

        //JDBC连接本机数据库SQL Server
        /*
        1. 加载数据库驱动程序
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        2. 创建数据库连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=master";
            String user = "sa";
            String password = "abc";
            DriverManager.getConnection(url, user, password);
         */

        //对数据库的操作
        /*
        1. 创建Statement对象
          Statement stmt = conn.createStatement();
        2. 执行SQL语句
            ResultSet rs = stmt.executeQuery("select * from student");
        3. 处理查询结果
            while (rs.next()) {
                System.out.println(rs.getString("name")); //输出name字段的值
            }
        4. 关闭数据库连接
            rs.close();
            stmt.close();
            conn.close();
         */

        //预处理语句
        /*
        以插入数据为例:
        1. 创建PreparedStatement对象
          PreparedStatement pstmt = conn.prepareStatement("insert into student(name,age) values(?,?)"); //?是占位符
        2. 设置参数值
            pstmt.setString(1, "张三"); //设置第一个参数的值为"张三"
            pstmt.setInt(2, 20); //设置第二个参数的值为20
        3. 执行SQL语句
            pstmt.executeUpdate(); //执行插入操作
        4. 关闭数据库连接
            pstmt.close();
            conn.close();

        以查询数据为例:
        1. 创建PreparedStatement对象
          PreparedStatement pstmt = conn.prepareStatement("select * from student where name=?"); //?是占位符
        2. 设置参数值
            pstmt.setString(1, "张三"); //设置第一个参数的值为"张三"
        3. 执行SQL语句
            ResultSet rs = pstmt.executeQuery(); //执行查询操作
        4. 处理查询结果
            while (rs.next()) {
                System.out.println(rs.getString("name")); //输出name字段的值
            }
        5. 关闭数据库连接
            rs.close();
            pstmt.close();
            conn.close();

        以更新数据为例:
        1. 创建PreparedStatement对象
          PreparedStatement pstmt = conn.prepareStatement("update student set age=? where name=?"); //?是占位符
        2. 设置参数值
            pstmt.setInt(1, 21); //设置第一个参数的值为21
            pstmt.setString(2, "张三"); //设置第二个参数的值为"张三"
        3. 执行SQL语句
            pstmt.executeUpdate(); //执行更新操作
        4. 关闭数据库连接
            pstmt.close();
            conn.close();

        以删除数据为例:
        1. 创建PreparedStatement对象
          PreparedStatement pstmt = conn.prepareStatement("delete from student where name=?"); //?是占位符
        2. 设置参数值
            pstmt.setString(1, "张三"); //设置第一个参数的值为"张三"
        3. 执行SQL语句
            pstmt.executeUpdate(); //执行删除操作
        4. 关闭数据库连接
            pstmt.close();
            conn.close();

        以批处理为例:
        批处理是一次性执行多条SQL语句,可以提高数据库操作的效率。
        1. 创建PreparedStatement对象
          PreparedStatement pstmt = conn.prepareStatement("insert into student(name,age) values(?,?)"); //?是占位符
        2. 设置参数值
            pstmt.setString(1, "张三"); //设置第一个参数的值为"张三"
            pstmt.setInt(2, 20); //设置第二个参数的值为20
            pstmt.addBatch(); //添加到批处理中
            pstmt.setString(1, "李四"); //设置第一个参数的值为"李四"
            pstmt.setInt(2, 21); //设置第二个参数的值为21
            pstmt.addBatch(); //添加到批处理中
        3. 执行批处理
            pstmt.executeBatch(); //执行批处理
        4. 关闭数据库连接
            pstmt.close();
            conn.close();


         */
    }
}