package pe.edu.cibertec.demoapirest.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.demoapirest.model.Category;
import pe.edu.cibertec.demoapirest.repository.CategoryRepository;


import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listarCategorias(){
        return categoryRepository.findAll();
    }

}
