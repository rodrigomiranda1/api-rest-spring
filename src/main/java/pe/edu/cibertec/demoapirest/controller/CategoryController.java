package pe.edu.cibertec.demoapirest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.demoapirest.model.Category;
import pe.edu.cibertec.demoapirest.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    //localhost:/8080/api/v1/category
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<List<Category>>(categoryService.listarCategorias(), HttpStatus.OK);
    }

}
