package pe.edu.cibertec.demoapirest.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.demoapirest.model.Supplier;
import pe.edu.cibertec.demoapirest.repository.SupplierRepository;


import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> listarProveedores(){
        //select * from suppliers;
        return supplierRepository.findAll();
    }
}
