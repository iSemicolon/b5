package org.kol.backend.service;
import org.kol.backend.entity.Product;
import org.kol.backend.entity.ProductCategory;
import org.kol.backend.repository.ProductCategoryRepository;
import org.kol.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Transactional
    public Product createProduct(Product product, Long categoryId) {
        // Retrieve the category from the repository
        ProductCategory category = productCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Set the category for the product
        product.setCategory(category);

        // Save the product entity
        return productRepository.save(product);
    }




    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product updateProduct(Long id, Product updatedProduct, Long categoryId) {
        return productRepository.findById(id).map(product -> {
            // Retrieve the category from the repository
            ProductCategory category = productCategoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            // Update product details
            product.setCategory(category);
            product.setSku(updatedProduct.getSku());
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setUnitPrice(updatedProduct.getUnitPrice());
            product.setImageUrl(updatedProduct.getImageUrl());
            product.setActive(updatedProduct.isActive());
            product.setUnitsInStock(updatedProduct.getUnitsInStock());

            // Save the updated product
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}

