package ru.shop.shoppingcart.controller.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop.shoppingcart.dto.ProductDTO;
import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> readAll(Pageable pageable) {
        return ResponseEntity.ok(productService.readAll());
    }

    @GetMapping("/find-by-stock")
    public List<Product> readByActive(@RequestParam(value = "in_stock") Boolean inStock) {
        return productService.readByActive(inStock);
    }
}
