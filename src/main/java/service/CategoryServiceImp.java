package service;

import model.Category;
import DAO.CategoryDaoImpl;

import java.util.List;

public class CategoryServiceImp implements ICategoryService {
CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    @Override
    public Category createCategory(Category category) throws Exception {
        return categoryDao.save(category);
    }

    @Override
    public Category getCategoryById(long id) throws Exception {
        return categoryDao.findById(id);
    }

    @Override
    public Category updateCategory(Category category) throws Exception {
        return categoryDao.update(category);
    }

    @Override
    public void deleteCategory(long id) throws Exception {
categoryDao.delete(id);
    }

    @Override
    public List<Category> getAll() throws Exception {
     return categoryDao.findAll();
    }

}
