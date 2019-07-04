package DAO;

import databaseConnection.ConnectionDB;
import model.Event;
import model.HashTag;
import service.CategoryServiceImp;
import service.EventServiceImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventDaoImp implements EventDAO {

    @Override
    public Event save(Event event) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "INSERT INTO event (name, date,contact_number, id_category, description, url_image) VALUES (?,?,?,?,?,?) returning id";

        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setString(1, event.getName());
        statement.setDate(2, Date.valueOf(event.getDate()));
        statement.setString(3, event.getContactTelNum());
        statement.setLong(4, event.getIdCategory());
        statement.setString(5, event.getDescription());
        statement.setString(6, event.getUrlImage());

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            event.setId(resultSet.getLong("id"));
        }
        statement.close();
        connectionDB.getConnection().close();


        event.getTags().forEach(tag -> {
            try {

                this.getTagsByListOfStringId(event, tag);

            } catch (SQLException e) {

                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        return event;
    }

    @Override
    public Event update(Event event) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "UPDATE event SET name=?, contact_number=?,id_category=?, description=?, url_image=?, date=? WHERE id=" + event.getId();
        LocalDate date;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        EventServiceImpl eventService = new EventServiceImpl();
        date = LocalDate.parse(event.getDate().format(formatter));

        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setString(1, event.getName());
        statement.setString(2, event.getContactTelNum());
        statement.setLong(3, event.getIdCategory());
        statement.setString(4, event.getDescription());
        statement.setString(5, event.getUrlImage());
        statement.setDate(6, Date.valueOf(event.getDate().format(formatter)));

        String SQLTags = "UPDATE hash_for_event SET id_hash =?, id_event=?  WHERE id=" + event.getId();
        PreparedStatement statement1 = connectionDB.getConnection().prepareStatement(SQL);

        statement1.execute();
        statement1.close();
        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
        return event;
    }


    @Override
    public void delete(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "DELETE FROM public.event WHERE event.id=" + id;
        String query ="DELETE FROM hash_for_event WHERE id_event="+id;
        PreparedStatement statementHash = connectionDB.getConnection().prepareStatement(query);
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);

        statementHash.executeUpdate();
        statement.executeUpdate();
        statementHash.close();
        statement.close();
        connectionDB.getConnection().close();

    }

    @Override
    public Event findById(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        Event event = new Event();
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        String SQL = "SELECT category.name as cat_name, event.id, event.name, event.contact_number, event.id_category, event.description,  event.url_image, event.date, tag.id  as id_tag, tag.name  as name_tag" +
                " FROM hash_for_event JOIN hashtag as tag ON hash_for_event.id_hash=tag.id" +
                " JOIN event ON hash_for_event.id_event = event.id JOIN category ON category.id=event.id_category WHERE event.id=" + id +
                " GROUP BY event.id, category.name, tag.id ";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);

        ResultSet resultSet = statement.executeQuery();
        boolean isEmpty = true;
        List<HashTag> hashes = new ArrayList<>();

        while (resultSet.next()) {
            if (isEmpty) {
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setDate(resultSet.getDate("date").toLocalDate());
                event.setContactTelNum(resultSet.getString("contact_number"));
                event.setIdCategory(resultSet.getLong("id_category"));
                event.setDescription(resultSet.getString("description"));
                event.setUrlImage(resultSet.getString("url_image"));
                event.setCategory(resultSet.getString("cat_name"));
                isEmpty = false;
            }
            HashTag hashTag = new HashTag(resultSet.getLong("id_tag"), resultSet.getString("name_tag"));
            hashes.add(hashTag);
        }
        event.setTags(hashes);
        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();
        return event;

    }

    @Override
    public List<Event> findAll() throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        EventServiceImpl eventService = new EventServiceImpl();
        List<Event> foundedEvents = new ArrayList<>();
        String query = "SELECT id FROM event";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        while (resultSet.next()) {
           foundedEvents.add(eventService.getEventById(resultSet.getLong("id")));
        }
        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();
        return foundedEvents;
    }

    @Override
    public List<Event> findByName(String name) throws Exception {
        EventServiceImpl eventService = new EventServiceImpl();
        ConnectionDB connectionDB = new ConnectionDB();
        List<Event> foundedEvents = new ArrayList<>();
        String query = "SELECT * FROM event WHERE name=" + name;
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        while (resultSet.next()) {
            foundedEvents.add(eventService.getEventById(resultSet.getLong("id")));
        }

        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();

        return foundedEvents;

    }

    @Override
    public List<Event> findByCategory(Long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        EventServiceImpl eventService = new EventServiceImpl();

        List<Event> foundedEvents = eventService.getAll();
        foundedEvents = foundedEvents.stream().filter(e -> e.getIdCategory() == id).collect(Collectors.toList());

        return foundedEvents;
    }

    @Override
    public void getTagsByListOfStringId(Event event, HashTag hashTag) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String query = "INSERT INTO hash_for_event (id_event, id_hash) VALUES (?, ?)";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(query);
        statement.setLong(1, event.getId());
        statement.setLong(2, hashTag.getId());

        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
    }

}
