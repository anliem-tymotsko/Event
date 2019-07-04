package service;

import model.Event;
import DAO.EventDaoImp;
import model.HashTag;

import java.util.List;

public class EventServiceImpl implements IEventService {
    private EventDaoImp eventDaoImp = new EventDaoImp();

    @Override
    public Event createEvent(Event event) throws Exception {
        return eventDaoImp.save(event);
    }

    @Override
    public Event getEventById(long id) throws Exception {
        return eventDaoImp.findById(id);
    }

    @Override
    public Event updateEvent(Event event) throws Exception {
        return eventDaoImp.update(event);
    }

    @Override
    public void deletePost(long id) throws Exception {
        eventDaoImp.delete(id);
    }

    @Override
    public List<Event> getAll() throws Exception {
        return eventDaoImp.findAll();
    }

    @Override
    public List<Event> findByName(String name) throws Exception {
        return eventDaoImp.findByName(name);
    }

    @Override
    public List<Event> findByCategory(Long id) throws Exception {
        return eventDaoImp.findByCategory(id);
    }

    @Override
    public void getTagsByListOfStringId(Event event, HashTag hashTag) throws Exception {
        eventDaoImp.getTagsByListOfStringId(event, hashTag);
    }

}
