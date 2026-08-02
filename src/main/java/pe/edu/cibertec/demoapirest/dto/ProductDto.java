package pe.edu.cibertec.demoapirest.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer productid;
    private String productname;
    private Integer categoryid;
    private Integer supplierid;
    private boolean discontinued;
}
