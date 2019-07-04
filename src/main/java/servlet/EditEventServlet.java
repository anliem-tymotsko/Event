package servlet;

import model.Category;
import model.Event;
import service.CategoryServiceImp;
import service.EventServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "EditEventServlet", urlPatterns = "/editEvent")
public class EditEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Event event = new Event();

      EventServiceImpl eventService =  new EventServiceImpl();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        String date = String.format(request.getParameter("date"), formatter);


        event.setName(request.getParameter("name"));
        event.setDate(LocalDate.parse(request.getParameter("date")));

        event.setUrlImage(request.getParameter("url_image"));
        event.setContactTelNum(request.getParameter("contact_number"));


        try {
            event.setIdCategory(Long.parseLong(request.getParameter("id_category")));
        } catch (Exception e) {
            e.printStackTrace();

        }

        event.setDescription(request.getParameter("description"));
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            eventService.createEvent(event);
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            eventService.deletePost(Long.parseLong(request.getParameter("id")));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        EventServiceImpl eventService = new EventServiceImpl();
        try {

            List<Category> categories = categoryServiceImp.getAll();
            request.setAttribute("categories", categories);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Event event = new Event();
        try {
         event = eventService.getEventById(Long.parseLong(request.getParameter("id")));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        request.setAttribute("event", event);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editEvent.jsp");
        requestDispatcher.include(request, response);

    }
}
