package servlet;

import service.EventServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEventServlet", urlPatterns = "/delete")
public class DeleteEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventServiceImpl eventService = new EventServiceImpl();
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            eventService.deletePost(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog.jsp");
        requestDispatcher.include(request, response);
        response.sendRedirect(request.getContextPath()+"/blog");
    }
}
