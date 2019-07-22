package servlet;

import entity.Customer;
import service.RegisterService;
import service.impl.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.CheckRegisterServlet", urlPatterns = "/servlet/CheckRegisterServlet")
public class CheckRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码格式
        resp.setContentType("text/html;charset=utf-8");

        //获取请求信息
        String reg_name = req.getParameter("reg_name");
        String reg_pwd = req.getParameter("reg_pwd");

        //进行注册
        RegisterService registerService = new RegisterServiceImpl();
        Customer existingCustomer = registerService.checkRegisterService(reg_name, reg_pwd);

        if (null == existingCustomer) {
            resp.getWriter().write("注册成功！");
        } else {
            resp.getWriter().write("注册失败！已有同名用户");
        }
    }
}
