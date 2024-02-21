package api.controller.v1;

import api.service.ProductService;
import api.dto.ProductDTO;
import api.entity.Product;
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
