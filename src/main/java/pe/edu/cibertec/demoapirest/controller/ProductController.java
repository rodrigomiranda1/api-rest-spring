package pe.edu.cibertec.demoapirest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.demoapirest.dto.ProductDto;
import pe.edu.cibertec.demoapirest.model.Category;
import pe.edu.cibertec.demoapirest.model.Product;
import pe.edu.cibertec.demoapirest.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.listarProductos(), HttpStatus.OK);
    }

    //localhost:8080/api/v1/product/1
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.buscarProductoPorId(id), HttpStatus.OK);
    }

    //localhost:8080/api/v1/product
    @PostMapping
    public ResponseEntity<Map<String, String>> createProduct(@RequestBody ProductDto productDto){
        Map<String, String> response = new HashMap<>();

        try {
            productService.registrarProducto(productDto);
            response.put("mensaje", "Producto creado correctamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception e){
            response.put("mensaje", "Ocurrio un error al registrar el producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> actualizarProduct(@PathVariable Integer id,@RequestBody ProductDto productDto){
        Map<String, String> response = new HashMap<>();

        try {
            productDto.setProductid(id);
            productService.actualizarProducto(productDto);
            response.put("mensaje", "Producto actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception e){
            response.put("mensaje", "Ocurrio un error al actualizar el producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarProduct(@PathVariable Integer id ){
        Map<String, String> response = new HashMap<>();

        try {
            productService.eliminarProducto(id);
            response.put("mensaje", "Producto eliminado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
