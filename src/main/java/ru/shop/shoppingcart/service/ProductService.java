package ru.shop.shoppingcart.service;

import ru.shop.shoppingcart.dto.ProductDTO;
import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.mapper.ProductMapper;
import ru.shop.shoppingcart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Создает новый продукт на основе переданных данных DTO.
     *
     * @param dto DTO продукта для создания.
     * @return Созданный продукт.
     */
    public Product create(ProductDTO dto) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(dto);
        return productRepository.save(product);
    }

    /**
     * Получает список всех продуктов.
     *
     * @return Список всех продуктов.
     */
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    /**
     * Получает продукт по его ID.
     *
     * @param id ID продукта для поиска.
     * @return Продукт с указанным ID, если найден.
     * @throws RuntimeException если продукт с указанным ID не найден.
     */
    public Product readById(Integer id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find product by id" + id));
    }

    /**
     * Получает список продуктов по статусу наличия.
     *
     * @param in_stock Флаг наличия продукта.
     * @return Список продуктов с указанным статусом наличия.
     */
    public List<Product> readByActive(Boolean in_stock) {
        return productRepository.findByInStock(in_stock);
    }
}
