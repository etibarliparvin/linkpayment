package az.yigim.linkpayment.controller;

import az.yigim.linkpayment.entity.concretes.User;
import az.yigim.linkpayment.service.userService.UserServiceInter;
import az.yigim.linkpayment.utils.context.BeanContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private final UserServiceInter userService = BeanContext.userServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.findUserByUsernameAndPassword(username, password);
            request.getSession().setAttribute("loggedInUser", user);
            System.out.println(user);
        } catch (Exception e) {
            System.out.println("Some problem occurred");
        }
        response.sendRedirect("login.jsp");
    }
}
