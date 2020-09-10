package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.springdata.SpringDataCategoryRepository;

import java.util.Collection;

@Service
public class CategoryService {

    private final SpringDataCategoryRepository categoryRepository;

    public CategoryService(SpringDataCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Collection<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
