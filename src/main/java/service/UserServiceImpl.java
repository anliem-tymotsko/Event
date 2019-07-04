package service;

import DAO.UserDAOImpl;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserServiceI {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public User save(User user) throws Exception {
        return userDAO.save(user);
    }

    @Override
    public void delete(long id) throws Exception {
        userDAO.delete(id);
    }

    @Override
    public User findById(long id) throws Exception {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userDAO.findAll();
    }
}
