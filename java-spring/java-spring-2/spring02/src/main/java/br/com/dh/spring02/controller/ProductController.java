package br.com.dh.spring02.controller;

import br.com.dh.spring02.dto.ProductDTO;
import br.com.dh.spring02.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1, "Product 1", 10));
        products.add(new Product(2, "Product 2", 20));
        products.add(new Product(3, "Product 3", 30));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int id) {
        Optional<Product> product = products
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst();
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductDTO productDTO = new ProductDTO(product.get());
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        product.setId(products.size() + 1);
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        Optional<Product> product = products
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst();
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        products.remove(product.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        // return new ResponseEntity<>(products, HttpStatus.OK);
        return ResponseEntity.ok(products);
    }
}
