package pe.edu.cibertec.demoapirest.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.demoapirest.model.Supplier;
import pe.edu.cibertec.demoapirest.service.SupplierService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        return new ResponseEntity<List<Supplier>>(supplierService.listarProveedores(), HttpStatus.OK);
    }
}
