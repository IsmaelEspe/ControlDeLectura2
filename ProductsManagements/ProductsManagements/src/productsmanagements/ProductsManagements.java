package productsmanagements;

import productsmanagements.controller.ProductController;
import productsmanagements.services.iml.InventoryServiceImpl;
import productsmanagements.view.ProductView;

public class ProductsManagements {
    public static void main(String[] args) {
        ProductController controller = new ProductController(new InventoryServiceImpl());
        ProductView view = new ProductView(controller);

        view.showMenu();
    }
    
}