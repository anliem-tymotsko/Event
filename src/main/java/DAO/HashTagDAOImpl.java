package DAO;

import databaseConnection.ConnectionDB;
import model.HashTag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HashTagDAOImpl implements HashTagDAO {
    @Override
    public HashTag save(HashTag hashTag) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "INSERT INTO HashTag (name) VALUES (?)";

        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setString(1, hashTag.getName());
        statement.execute();
        statement.close();
        connectionDB.getConnection().close();
        return hashTag;

    }

    @Override
    public HashTag update(HashTag hashTag) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "UPDATE HashTag SET name=? WHERE id=" + hashTag.getId();
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setString(1, hashTag.getName());

        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
        return hashTag;

    }

    @Override
    public void delete(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        String SQL = "DELETE FROM hashtag WHERE id=" + id;
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connectionDB.getConnection().close();
    }

    @Override
    public HashTag findById(long id) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        HashTag hashTag = new HashTag();
        String SQL = "SELECT * FROM hashtag WHERE hashtag.id=?";// + id;
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        hashTag.setId(resultSet.getInt("id"));
        hashTag.setName(resultSet.getString("name"));

        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();
        return hashTag;
    }

    @Override
    public List<HashTag> findAll() throws Exception {
        ConnectionDB connectionDB = new ConnectionDB();
        List<HashTag> foundedHashes = new ArrayList<>();
        String SQL = "SELECT * FROM hashtag ";
        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            HashTag hashTag = new HashTag(
                    resultSet.getLong("id"),
                    resultSet.getString("name"));

            foundedHashes.add(hashTag);
        }
        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();

        return foundedHashes;
    }
}
