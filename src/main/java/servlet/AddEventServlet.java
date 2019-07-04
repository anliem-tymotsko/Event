package servlet;

import model.Category;
import model.Event;
import model.HashTag;
import service.CategoryServiceImp;
import service.EventServiceImpl;
import service.HashTagImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AddEvent", urlPatterns = "/addEvent")
public class AddEventServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HashTagImp hashTagImp = new HashTagImp();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        String date = String.format(request.getParameter("date"), formatter);
        EventServiceImpl eventService = new EventServiceImpl();
        Event event = new Event();
        event.setName(request.getParameter("name"));
        event.setDate(LocalDate.parse(request.getParameter("date")));
        String[] hashes = request.getParameterValues("hashes");
        event.setUrlImage(request.getParameter("url_image"));
        event.setContactTelNum(request.getParameter("contact_number"));

        List<HashTag> hashTags = null;
        try {

            hashTags = hashTagImp.getHashesList(Arrays.asList(hashes));
        } catch (SQLException e) {

            response.sendRedirect(request.getContextPath() + "/error?type=general");

        }
        try {
            event.setIdCategory(Long.parseLong(request.getParameter("id_category")));
        } catch (Exception e) {
            e.printStackTrace();

        }
        event.setTags(hashTags);
        event.setUrlImage("url_image");
        event.setDescription(request.getParameter("description"));
        try {
            eventService.createEvent(event);
        } catch (Exception e) {
            e.printStackTrace();

        }
        response.sendRedirect(request.getContextPath()+"/blog");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashTagImp hashTagImp = new HashTagImp();


        try {
            List<HashTag> hashes = hashTagImp.findAll();
            request.setAttribute("hashes", hashes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        try {

            List<Category> categories = categoryServiceImp.getAll();
            request.setAttribute("categories", categories);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.include(request, response);
    }
}
