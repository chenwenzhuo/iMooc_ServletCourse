package service;

import entity.Customer;

public interface LoginService {
    Customer checkLoginService(String u_name, String u_pwd);
}
