package pe.edu.cibertec.demoapirest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibertec.demoapirest.model.Product;


public interface ProductRepository extends JpaRepository<Product,
        Integer> {

    @Transactional
    @Modifying
    @Query(value = """
    update products set productname=:productname, supplierid=:supplierid,
        categoryid=:categoryid, discontinued=:discontinued 
    where productid=:productid
        """, nativeQuery = true)
    void updateProduct(@Param("productname") String productname,
                       @Param("supplierid") Integer supplierid,
                       @Param("categoryid") Integer categoryid,
                       @Param("discontinued") boolean discontinued,
                       @Param("productid") Integer productid);

    @Transactional
    @Modifying
    @Query(value = """
        update products set discontinued=:discontinued where productid=:productid
""", nativeQuery = true)
    void deleteProduct(@Param("discontinued") boolean discontinued,
                        @Param("productid") Integer productid);

}
