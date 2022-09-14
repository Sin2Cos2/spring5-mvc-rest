package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper
                .categoryToCategoryDTO(categoryRepository.findByName(name));
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository
                .findById(id)
                .map(categoryMapper::categoryToCategoryDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Category with " + " id doesn't exist"));
    }
}
