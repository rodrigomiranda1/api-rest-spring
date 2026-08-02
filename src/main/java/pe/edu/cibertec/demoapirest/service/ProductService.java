package pe.edu.cibertec.demoapirest.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.demoapirest.dto.ProductDto;
import pe.edu.cibertec.demoapirest.model.Category;
import pe.edu.cibertec.demoapirest.model.Product;
import pe.edu.cibertec.demoapirest.model.Supplier;
import pe.edu.cibertec.demoapirest.repository.ProductRepository;


import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listarProductos(){
        return productRepository.findAll();
    }
    public void registrarProducto(ProductDto dto){
        Category category = new Category();
        category.setCategoryid(dto.getCategoryid());
        Supplier supplier = new Supplier();
        supplier.setSupplierid(dto.getSupplierid());
        Product product = new Product();
        product.setProductname(dto.getProductname());
        product.setDiscontinued(dto.isDiscontinued());
        product.setCategories(category);
        product.setSuppliers(supplier);
        productRepository.save(product);
    }
    public void actualizarProducto(ProductDto dto){
        productRepository.updateProduct(dto.getProductname(),
                dto.getSupplierid(), dto.getCategoryid(), dto.isDiscontinued(),
                dto.getProductid());
    }

    public void eliminarProducto(Integer id){
        productRepository.deleteProduct(true,id);
    }


    public ProductDto buscarProductoPorId(Integer id){
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return  null;
        }else{
            ProductDto dto = new ProductDto();
            dto.setProductid(product.getProductid());
            dto.setProductname(product.getProductname());
            dto.setCategoryid(product.getCategories().getCategoryid());
            dto.setSupplierid(product.getSuppliers().getSupplierid());
            dto.setDiscontinued(product.getDiscontinued());
            return dto;
        }
    }
}
