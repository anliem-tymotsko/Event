package service;

import model.HashTag;

import java.sql.SQLException;
import java.util.List;

public interface HashTagService {
    HashTag save(HashTag hashTag) throws Exception;

    void delete(long id) throws Exception;

    HashTag findById(long id) throws Exception;

    List<HashTag> findAll() throws Exception;

    public List<HashTag> getHashesList(List<String> listOfTagsId) throws SQLException;
}
