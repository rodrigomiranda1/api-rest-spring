package pe.edu.cibertec.demoapirest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;
    private String productname;
    private Integer unitsinstock;
    private String quantityperunit;
    private Double unitprice;
    private Integer unitsonorder;
    private Integer reorderlevel;
    private Boolean discontinued;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category categories;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier suppliers;

}
