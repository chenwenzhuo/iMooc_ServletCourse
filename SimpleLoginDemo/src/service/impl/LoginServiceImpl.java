package service.impl;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import entity.Customer;
import service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao = new LoginDaoImpl();
    @Override
    public Customer checkLoginService(String u_name, String u_pwd) {
        return loginDao.checkLoginDao(u_name, u_pwd);
    }
}
