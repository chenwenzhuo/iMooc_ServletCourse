package dao;

import entity.Customer;

public interface LoginDao {
    Customer checkLoginDao(String u_name, String u_pwd);
}
