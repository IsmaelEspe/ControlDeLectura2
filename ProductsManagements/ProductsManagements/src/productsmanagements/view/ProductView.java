package productsmanagements.view;

import productsmanagements.controller.ProductController;
import productsmanagements.models.Products;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static final Scanner scanner = new Scanner(System.in);
    private final ProductController controller;

    public ProductView(ProductController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===========================MENÚ DE PRODUCTOS==============================");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Actualizar Cantidad Producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del sistema....");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private void addProduct() {
        System.out.print("Ingrese el nombre del Producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.print("Ingrese el precio del Producto: ");
        Double precioProducto = scanner.nextDouble();
        System.out.print("Ingrese la cantidad del Producto: ");
        int cantidadProducto = scanner.nextInt();
        scanner.nextLine();

        String message = controller.createProduct(nombreProducto, precioProducto, cantidadProducto);
        System.out.println(message);
    }

    private void updateProduct() {
        System.out.print("Ingrese el nombre del Producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingrese la cantidad del Producto: ");
        int cantidadProducto = scanner.nextInt();
        scanner.nextLine();

        String message = controller.updateProduct(nombreProducto, cantidadProducto);
        System.out.println(message);
    }

    private void listProducts() {
        List<Products> products = controller.listProducts();

        if (products.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            System.out.println("\n========================= LISTA DE PRODUCTOS =========================");
            double totalPrice = 0;

            for (Products p: products) {
                System.out.println("Producto: " + p.getProductName() + ", Precio: " + p.getPrice() + ", Cantidad: " + p.getLot());
                totalPrice += p.getPrice() * p.getLot();
            }
            System.out.println("\nPrecio Total de los Productos: $" + totalPrice);
        }
    }
}