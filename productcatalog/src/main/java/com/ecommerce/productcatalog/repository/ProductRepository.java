package com.ecommerce.productcatalog.repository;

import com.ecommerce.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
//    basically a query ie select from table where categoryid =
}
