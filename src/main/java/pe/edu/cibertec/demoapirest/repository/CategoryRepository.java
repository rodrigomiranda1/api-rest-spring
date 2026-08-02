package pe.edu.cibertec.demoapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.demoapirest.model.Category;


public interface CategoryRepository extends JpaRepository<Category,
        Integer> {
}
