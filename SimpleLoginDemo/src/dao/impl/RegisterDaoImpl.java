package dao.impl;

import dao.RegisterDao;
import entity.Customer;

import java.sql.*;

public class RegisterDaoImpl implements RegisterDao {
    private Connection connection = null;
    private PreparedStatement prepStat = null;
    private ResultSet results = null;

    @Override
    public Customer checkRegisterDao(String reg_name, String reg_pwd) {
        //连接数据库
        connectDB();

        //检查当前数据库中是否存在同名用户
        Customer existingCustomer = findExistingCustomer(reg_name);//查找同名用户
        if (null != existingCustomer) {
            //若存在同名用户，返回此用户对象
            return existingCustomer;
        }

        try {
//            String insertSQLStat = "insert into user_info values(default," + reg_name + "," + reg_pwd + ")";
            String insertSQLStat = "insert into user_info values(default,?,?)";

            prepStat = connection.prepareStatement(insertSQLStat);
            prepStat.setString(1, reg_name);
            prepStat.setString(2, reg_pwd);

            prepStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }

        return null;
    }

    private void connectDB() {
        String DBUrl = "jdbc:mysql://localhost:3306/login_db?serverTimezone=UTC&useSSL=false";
        String DBLogin_name = "root";
        String DBLogin_pwd = "960812";

        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接
            connection = DriverManager.getConnection(DBUrl, DBLogin_name, DBLogin_pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void disconnectDB() {
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

    private Customer findExistingCustomer(String reg_name) {
        Customer existingCustomer = null;

        try {
            //sql语句字符串
            String sqlStat = "select * from user_info where u_name =?";

            //sql命令对象
            prepStat = connection.prepareStatement(sqlStat);
            //给占位符赋值
            prepStat.setString(1, reg_name);

            //执行查找
            results = prepStat.executeQuery();


            while (results.next()) {
                existingCustomer = new Customer();

                existingCustomer.setU_id(results.getInt("u_id"));
                existingCustomer.setU_name(results.getString("u_name"));
                existingCustomer.setU_pwd(results.getString("u_pwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existingCustomer;
    }
}
