package DAO;

import databaseConnection.ConnectionDB;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User save(User user) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "INSERT INTO users(name ,email, password) VALUES (?,?,?)";

        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());

        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
        return user;
    }


    @Override
    public void delete(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "DELETE FROM users WHERE id=?";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
    }

    @Override
    public User findById(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        User user = new User();
        String SQL = "SELECT * FROM users WHERE user.id=?"+id;
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));


        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();
        return user;
    }

    @Override
    public List<User> findAll() throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        List<User> foundedUser = new ArrayList<>();
        String SQL = "SELECT * FROM users ";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("email")
                    );

            foundedUser.add(user);
        }
        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();


        return foundedUser;
    }
}
