package api.version_1.service;

import lombok.AllArgsConstructor;
import api.version_1.dto.ProductDTO;
import api.version_1.entity.Product;
import api.version_1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(ProductDTO dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .inStock(dto.getInStock())
                .build();

        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product readById(Integer id) {
        return  productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find product by id" + id));
    }

    public List<Product> readByActive(Boolean in_stock) {
        return productRepository.findByInStock(in_stock);
    }
}
