package DAO;

import model.Category;

import java.util.List;

public interface CategoryDAO {
    Category save(Category category) throws Exception;

    Category update(Category category) throws Exception;

    void delete(long id) throws Exception;

    Category findById(long id) throws Exception;

    List<Category> findAll() throws Exception;

}
