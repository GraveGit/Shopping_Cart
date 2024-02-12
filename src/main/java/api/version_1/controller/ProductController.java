package api.version_1.controller;

import api.version_1.service.ProductService;
import lombok.AllArgsConstructor;
import api.version_1.dto.ProductDTO;
import api.version_1.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return new ResponseEntity<>(productService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        return new ResponseEntity<>(productService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/in_stock")
    public List<Product> readByActive(@RequestParam(value = "in_stock") Boolean inStock) {
        return productService.readByActive(inStock);
    }
}
