package servlet;

import entity.Customer;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.CheckLoginServlet", urlPatterns = "/servlet/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //编码格式
        resp.setContentType("text/html;charset=utf-8");

        //获取请求信息
        String name = req.getParameter("u_name");
        String pwd = req.getParameter("u_pwd");
        System.out.println(name + " : " + pwd);

        //检查用户名密码
        LoginService loginService = new LoginServiceImpl();
        Customer customer = loginService.checkLoginService(name, pwd);
        System.out.println(customer);

        if (null != customer) {
            resp.getWriter().write("登陆成功！");
        } else {
            resp.getWriter().write("登陆失败！");
        }
    }
}
