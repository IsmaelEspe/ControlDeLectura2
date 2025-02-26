package productsmanagements.services;

import productsmanagements.models.Products;

import java.util.List;

public interface InventoryService {
    List<Products> listProducts();
    Products createProduct(Products product);
    String updateProduct(String productName, int lot);
}