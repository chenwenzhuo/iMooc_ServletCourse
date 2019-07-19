package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_Url = "jdbc:mysql://localhost:3306/shopping?serverTimezone=UTC&useSSL=false";
    private static final String DB_User = "root";
    private static final String DB_UserPwd = "960812";

    //数据库连接对象
    private static Connection conn = null;

    //静态代码块，加载驱动
    static {
        try {
            Class.forName(DB_Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //单例模式返回数据库连接对象
    public static Connection getConnection() throws SQLException {
        if (null == conn) {
            conn = DriverManager.getConnection(DB_Url, DB_User, DB_UserPwd);
        }
        return conn;
    }
}
