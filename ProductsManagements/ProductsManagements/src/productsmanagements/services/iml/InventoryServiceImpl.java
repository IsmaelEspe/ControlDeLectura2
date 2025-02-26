package productsmanagements.services.iml;

import productsmanagements.models.Products;
import productsmanagements.services.InventoryService;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private List<Products> products;

    public InventoryServiceImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public List<Products> listProducts() {
        return products;
    }

    @Override
    public Products createProduct(Products product) {
        products.add(product);
        return product;
    }

    @Override
    public String updateProduct(String productName, int lot) {
        boolean isProduct = false;

        for (Products p: products) {
            if (p.getProductName().toLowerCase().equalsIgnoreCase(productName.toLowerCase())) {
                p.setLot(lot);
                isProduct = true;
                break;
            }
        }

        if (isProduct) {
            return "El producto " + productName + " se ha actualizado.";
        } else {
            return "Error: El producto " + productName + " no existe en el registro.";
        }
    }
}