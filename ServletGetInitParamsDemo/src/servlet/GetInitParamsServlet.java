package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetInitParamsServlet extends HttpServlet {
    //初始化参数
    private String username;//用户名
    private String userPwd;//用户密码

    @Override
    public void init() throws ServletException {
        this.setUsername(this.getInitParameter("username"));
        this.setUserPwd(this.getInitParameter("userPwd"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h2>获取到的初始化参数：</h2><br/>");
        out.println("用户名：" + this.getUsername() + "<br/>");
        out.println("用户密码：" + this.getUserPwd() + "<br/>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
