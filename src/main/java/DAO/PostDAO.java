package DAO;

import model.Post;

public interface PostDAO {
    Post makePost(Long idEvent) throws Exception;
}
