package pe.edu.cibertec.demoapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.demoapirest.model.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier,
        Integer> {
}
