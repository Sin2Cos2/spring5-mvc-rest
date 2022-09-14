package guru.springfamework.services;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);

    CategoryDTO getCategoryById(Long id);
}
