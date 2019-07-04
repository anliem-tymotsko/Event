package service;

import DAO.HashTagDAOImpl;
import model.HashTag;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HashTagImp implements HashTagService {
    HashTagDAOImpl hashTagDAO = new HashTagDAOImpl();

    @Override
    public HashTag save(HashTag hashTag) throws Exception {
        return hashTagDAO.save(hashTag);
    }


    @Override
    public void delete(long id) throws Exception {
        hashTagDAO.delete(id);
    }

    @Override
    public HashTag findById(long id) throws Exception {
        return hashTagDAO.findById(id);
    }


    @Override
    public List<HashTag> findAll() throws Exception {
        return hashTagDAO.findAll();
    }

    @Override
    public List<HashTag> getHashesList(List<String> listOfTagsId) throws SQLException {
        List<HashTag> hashes = new ArrayList<>();

        HashTagImp hashTagImp = new HashTagImp();

        for (String hashId : listOfTagsId) {

            try {
                hashes.add(hashTagImp.findById(Long.parseLong(hashId)));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return hashes;
    }
}
