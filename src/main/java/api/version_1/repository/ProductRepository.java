package api.version_1.repository;

import api.version_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Возможно не сработает, если так, то reaname to in_stock!
    List<Product> findByInStock(Boolean inStock);

}
