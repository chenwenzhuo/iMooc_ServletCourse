package dao.impl;

import dao.LoginDao;
import entity.Customer;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public Customer checkLoginDao(String u_name, String u_pwd) {
        Connection connection = null;
        PreparedStatement prepStat = null;
        ResultSet results = null;

        //String DBUrl = "jdbc:mysql://localhost:3306/login_db?serverTimezone=UTC&useSSL=false";
        String DBUrl = "jdbc:mysql://localhost:3306/login_db?" +
                "serverTimezone=Asia/Shanghai&useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "960812";

        Customer customer = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接对象
            connection = DriverManager.getConnection(DBUrl, user, password);

            //SQL语句
            String sql = "select * from user_info where u_name=?";//其中 ? 是占位符

            //创建SQL命令对象
            prepStat = connection.prepareStatement(sql);
            //给占位符赋值
            prepStat.setString(1, u_name);
            //prepStat.setString(2, u_pwd);

            //执行SQL命令
            results = prepStat.executeQuery();

            //遍历执行结果
            while (results.next()) {
                customer = new Customer();
                customer.setU_id(results.getInt("u_id"));
                customer.setU_name(results.getString("u_name"));

                //检查密码是否正确，即输入的密码与数据库中的密码是否一致
                if (results.getString("u_pwd").equals(u_pwd)) {
                    customer.setU_pwd(results.getString("u_pwd"));
                } else {
                    customer.setU_pwd(null);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                results.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                prepStat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return customer;
    }
}
