package DAO;

import databaseConnection.ConnectionDB;
import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDAO {
    @Override
    public Category save(Category category) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "INSERT INTO category (name) VALUES (?)";

        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setString(1, category.getName());
        statement.execute();
        statement.close();
        connectionDB.getConnection().close();
        return category;

    }

    @Override
    public Category update(Category category) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "UPDATE category SET name=? WHERE id=?";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setString(1, category.getName());

        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
        return category;
    }

    @Override
    public void delete(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "DELETE FROM category WHERE id=?";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
    }

    @Override
    public Category findById(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        Category category = new Category();
        String SQL = "SELECT * FROM category WHERE category.id=?";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        category.setId(resultSet.getInt("id"));
        category.setName(resultSet.getString("name"));


        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();
        return category;

    }

    @Override
    public List<Category> findAll() throws Exception {

        ConnectionDB connectionDB = new ConnectionDB();
        List<Category> foundedCategories = new ArrayList<>();
        String query = "SELECT * FROM category ";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Category categoryPosted = new Category(
                    resultSet.getLong("id"),
                    resultSet.getString("name"));
            foundedCategories.add(categoryPosted);
        }
        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();



        return foundedCategories;
    }
}
