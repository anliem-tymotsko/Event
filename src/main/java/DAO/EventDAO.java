package DAO;


import model.Event;
import model.HashTag;

import java.util.List;

public interface EventDAO {
    Event save(Event event) throws Exception;

    Event update(Event event) throws Exception;

    void delete(long id) throws Exception;

    Event findById(long id) throws Exception;

    List<Event> findAll() throws Exception;

    List<Event> findByName(String name) throws Exception;

    List<Event> findByCategory(Long id) throws Exception;

   void getTagsByListOfStringId(Event event, HashTag hashTag) throws Exception;



}
