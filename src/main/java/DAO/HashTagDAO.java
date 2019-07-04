package DAO;

import model.HashTag;

import java.util.List;

public interface HashTagDAO {

    HashTag save(HashTag hashTag) throws Exception;

    HashTag update(HashTag hashTag) throws Exception;

    void delete(long id) throws Exception;

    HashTag findById(long id) throws Exception;

    List<HashTag> findAll() throws Exception;



}
