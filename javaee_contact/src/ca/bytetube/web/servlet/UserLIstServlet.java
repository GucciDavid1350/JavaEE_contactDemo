package ca.bytetube.web.servlet;

import ca.bytetube.domain.User;
import ca.bytetube.service.UserService;
import ca.bytetube.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserLIstServlet")
public class UserLIstServlet extends HttpServlet {
    UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用userService完成查询
        List<User> users = service.findAll();
        //2.将查询回来的数据存入request域中
        request.setAttribute("users",users);
        //3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
