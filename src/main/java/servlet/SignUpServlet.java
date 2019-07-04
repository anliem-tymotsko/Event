package servlet;

import model.User;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        String password =request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        if (password.equals(confPassword))
        {
            String pass = request.getParameter("password");
           String encPass = Base64.getEncoder().encodeToString(pass.getBytes());
            user.setPassword(encPass);
        }
        Base64.getEncoder();
        user.setName(request.getParameter("user_name"));
        user.setEmail(request.getParameter("email"));
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/signIn");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("signUp.jsp");
        requestDispatcher.forward(request, response);
    }


}
