package service;

import entity.Customer;

public interface RegisterService {
    Customer checkRegisterService(String reg_name, String reg_pwd);
}
