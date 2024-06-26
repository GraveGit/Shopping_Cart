package ru.shop.shoppingcart.mapper;

import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productDTOToProduct(ProductDTO dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "inStock", target = "inStock")
    ProductDTO productToProductDTO(Product product);
}
