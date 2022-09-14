package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CategoryListDTO;
import guru.springfamework.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {

        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String categoryName) {

        return categoryService.getCategoryByName(categoryName);
    }
}
