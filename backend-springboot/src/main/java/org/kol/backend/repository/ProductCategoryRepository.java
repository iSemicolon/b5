package org.kol.backend.repository;

import org.kol.backend.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


// name of json entry= productCategory
//path= /product-category
//@RepositoryRestResource(collectionResourceRel="productCategory", path="product-category")

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
