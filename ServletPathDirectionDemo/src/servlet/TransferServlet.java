package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //请求重定向方式
        /*response.sendRedirect("destination.jsp");
         * 这种写法会在当前目录（ServletPathDirectionDemo/servlet）下寻找destination.jsp，错误*/
        //请求重定向正确写法
        //response.sendRedirect(request.getContextPath() + "/destination.jsp");

        //服务器内部跳转方式
        /*request.getRequestDispatcher("destination.jsp").forward(request, response);
        * 使用相对路径，错因与上方一致*/
        //服务器内部跳转正确写法
        request.getRequestDispatcher("/destination.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
