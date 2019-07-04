package servlet;

import databaseConnection.ConnectionDB;
import model.User;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SignInServlet", urlPatterns = "/signIn")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionDB connectionDB = new ConnectionDB();

        User user = new User();
        String name = request.getParameter("user_name");
        String password = request.getParameter("password");

        UserServiceImpl userService = new UserServiceImpl();
        List<User> users = new ArrayList<>();
        try {
            users = userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        users = users.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
        if (users.size()!=0){
            if ( Base64.getEncoder().encodeToString(password.getBytes()).equals(users.get(0).getPassword())) {
                response.sendRedirect(request.getContextPath()+"/blog");
            } else System.out.println("error");}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("signIn.jsp");
        requestDispatcher.forward(request, response);
    }
}
