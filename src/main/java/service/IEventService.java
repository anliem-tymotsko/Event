package service;

import model.Event;
import model.HashTag;

import java.util.List;

public interface IEventService {
    Event createEvent(Event event) throws Exception;

    Event getEventById(long id) throws Exception;

    Event updateEvent(Event event) throws Exception;

    void deletePost(long id) throws Exception;

    List<Event> getAll() throws Exception;

    List<Event> findByName(String name) throws Exception;

    List<Event> findByCategory(Long id) throws Exception;

    void getTagsByListOfStringId(Event event, HashTag hashTag) throws Exception;

}
