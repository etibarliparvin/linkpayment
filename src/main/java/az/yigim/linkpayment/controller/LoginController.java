package az.yigim.linkpayment.controller;

import az.yigim.linkpayment.entity.concretes.User;
import az.yigim.linkpayment.service.userService.UserServiceInter;
import az.yigim.linkpayment.utils.context.BeanContext;
import az.yigim.linkpayment.utils.encrypter.EncrypterInter;

import javax.enterprise.inject.spi.Bean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private final UserServiceInter userService = BeanContext.userServiceImpl();
    private final EncrypterInter encrypter = BeanContext.encrypterImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userService.findUserByUsernameAndPassword(email, password);
            request.getSession().setAttribute("loggedInUser", user);
//            response.sendRedirect("users");
            System.out.println(user);
        } catch (Exception e) {
            System.out.println("Some problem occurred");
        }
    }
}
