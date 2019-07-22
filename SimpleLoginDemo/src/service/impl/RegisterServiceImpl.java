package service.impl;

import dao.RegisterDao;
import dao.impl.RegisterDaoImpl;
import entity.Customer;
import service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
    private RegisterDao registerDao = new RegisterDaoImpl();
    @Override
    public Customer checkRegisterService(String reg_name, String reg_pwd) {
        return registerDao.checkRegisterDao(reg_name, reg_pwd);
    }
}
