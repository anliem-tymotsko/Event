package DAO;

import databaseConnection.ConnectionDB;
import model.Post;
import service.CategoryServiceImp;
import service.EventServiceImpl;
import service.HashTagImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PostDaoImpl implements PostDAO {

    @Override
    public Post makePost(Long idEvent) throws Exception {
        Post post = new Post();
        ConnectionDB connectionDB = new ConnectionDB();
        EventServiceImpl eventService = new EventServiceImpl();
        HashTagImp hashTagImp = new HashTagImp();
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        try {
            post.setEvent(eventService.getEventById(idEvent));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            post.setCategory(categoryServiceImp.getCategoryById(post.getEvent().getIdCategory()).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String SQL = "SELECT * FROM hash_for_event WHERE id_event=" + idEvent;

        List<String> hashes = null;

        PreparedStatement statement = connectionDB.getConnection().prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            hashes.add(hashTagImp.findById(resultSet.getLong("id_hash")).getName());
        }
        resultSet.close();
        statement.close();
        connectionDB.getConnection().close();
        post.setHashTags(hashes);
        return post;
    }
}
