package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.RegisterServlet",urlPatterns = "/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码格式
        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<form action='CheckRegisterServlet' method='get'>");
        resp.getWriter().write("用户名：<input type='text' name='reg_name'/><br/>");
        resp.getWriter().write("密  码：<input type='password' name='reg_pwd'/><br/>");
        resp.getWriter().write("<input type='submit' value='注册'/><br/>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
