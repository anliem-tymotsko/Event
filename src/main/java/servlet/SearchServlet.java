package servlet;

import model.Event;
import service.EventServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventServiceImpl eventService = new EventServiceImpl();
        List<Event> events = null;
if(!request.getParameter("name_find").equals("")) {
    try {
        events = eventService.findByName(request.getParameter("name_find"));
        request.setAttribute("events", events);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog.jsp");
        requestDispatcher.include(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
        requestDispatcher.include(request, response);
    }
}
