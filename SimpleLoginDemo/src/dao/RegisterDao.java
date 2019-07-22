package dao;

import entity.Customer;

public interface RegisterDao {
    Customer checkRegisterDao(String reg_name, String reg_pwd);
}
