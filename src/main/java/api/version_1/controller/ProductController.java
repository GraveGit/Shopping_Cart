package api.version_1.controller;

import api.version_1.dto.ProductDTO;
import api.version_1.entity.Product;
import api.version_1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        return ResponseEntity.ok(productService.readAll());
    }

    @GetMapping("/in_stock")
    public List<Product> readByActive(@RequestParam(value = "in_stock") Boolean inStock) {
        return productService.readByActive(inStock);
    }
}
