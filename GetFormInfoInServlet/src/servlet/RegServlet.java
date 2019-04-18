package servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//设置字符集，避免中文乱码
        User newUser = new User();//创建用户实例，封装表单传递的数据

        //变量用来接收表单传输的数据
        String username;//用户名
        String userPwd;//密码
        String gender;//性别
        Date birthday;//生日
        String email;//电子邮箱
        String[] favorites;//爱好
        String introduction;//自我介绍
        String accAgreement;//是否接受用户协议

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            username = request.getParameter("username");
            userPwd = request.getParameter("userPwd");
            gender = request.getParameter("gender");
            email = request.getParameter("email");
            introduction = request.getParameter("introduction");
            favorites = request.getParameterValues("favorites");//获取多个复选框的值
            birthday = sdf.parse(request.getParameter("birthday"));
            if (null != request.getParameterValues("accAgreement")) {
                accAgreement = "true";
            } else {
                accAgreement = "false";
            }

            newUser.setUsername(username);
            newUser.setUserPwd(userPwd);
            newUser.setGender(gender);
            newUser.setEmail(email);
            newUser.setBirthday(birthday);
            newUser.setFavorites(favorites);
            newUser.setIntroduction(introduction);
            newUser.setAccAgreement("true".equals(accAgreement));

            //将新注册的用户对象保存到session中
            request.getSession().setAttribute("regUser", newUser);

            //跳转到用户信息展示页面
            request.getRequestDispatcher("../displayUserInfo.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //由于表单使用post方式提交，只需使doGet()方法与doPost()方法执行相同操作即可
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
