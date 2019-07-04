package service;

import model.Category;

import java.util.List;

public interface ICategoryService  {
    Category createCategory(Category category) throws Exception;

    Category getCategoryById(long id) throws Exception;

    Category updateCategory(Category category) throws Exception;

    void deleteCategory(long id) throws Exception;

    List<Category> getAll() throws Exception;
}
