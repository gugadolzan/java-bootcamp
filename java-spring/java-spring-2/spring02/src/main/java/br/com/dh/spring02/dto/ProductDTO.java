package br.com.dh.spring02.dto;

import br.com.dh.spring02.model.Product;
import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private double value;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.value = product.getValue();
    }
}
