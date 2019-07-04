package DAO;

import model.User;

import java.util.List;

public interface UserDAO {
    User save(User user) throws Exception;

    void delete(long id) throws Exception;

    User findById(long id) throws Exception;

    List<User> findAll() throws Exception;
}
