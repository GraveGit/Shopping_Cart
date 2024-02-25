package api.service;

import api.dto.ProductDTO;
import api.entity.Product;
import api.mapper.ProductMapper;
import api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(ProductDTO dto) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(dto);
        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product readById(Integer id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find product by id" + id));
    }

    public List<Product> readByActive(Boolean in_stock) {
        return productRepository.findByInStock(in_stock);
    }
}
