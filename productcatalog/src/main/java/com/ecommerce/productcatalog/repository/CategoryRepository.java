package com.ecommerce.productcatalog.repository;

import com.ecommerce.productcatalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
