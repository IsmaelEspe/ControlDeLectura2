package productsmanagements.controller;

import productsmanagements.models.Products;
import productsmanagements.services.InventoryService;

import java.util.List;

public class ProductController {
    private InventoryService inventoryService;

    public ProductController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public String createProduct(String productName, Double price, int lot) {
        Products product = new Products(productName, price, lot);
        inventoryService.createProduct(product);
        return "El producto " + product.getProductName() +" se creó con éxito.";
    }

    public List<Products> listProducts() {
        return inventoryService.listProducts();
    }

    public String updateProduct(String productName, int lot) {
        return inventoryService.updateProduct(productName, lot);
    }
}