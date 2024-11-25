import java.util.Scanner;

public class Exercise4 {
    private static ProductManager products;

    public static void main(String[] args) {
        initalize();
        app();
    }
    private static void initalize() {
        products = new ProductManager();
        products.addProduct(new Product(42, "T-Shirt", 120));
        products.addProduct(new Product(11, "Iphone", 1490));
        products.addProduct(new Product(27, "Kitchen knife", 327));
    }
    private static void app() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Edit Product");
            System.out.println("4. Display List Of Product");
            System.out.println("5. Sort Product By Price");
            System.out.println("6. Find Product By Name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    sortProducts();
                    break;
                case 6:
                    findProductByName();
                    break;
                case 0:
                    System.out.println("Program Exited");
                    exit = true;
                    break;
                default:
                    System.out.println("*** Invalid Option ***");
                    break;
            }

            System.out.println("Press enter to continue...");
            scanner.nextLine();
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    private static void addProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Add Product ===");
            System.out.print("Id: ");
            int id = scanner.nextInt();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Price: ");
            double price = scanner.nextDouble();

            if (products.addProduct(new Product(id, name, price))) {
                System.out.println("Product added");
            } else {
                System.out.println("Product not added");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again");
        }
    }

    private static void removeProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Remove Product ===");
            System.out.print("Enter Id of the product: ");
            int id = scanner.nextInt();

            if (products.removeProduct(id) != -1) {
                System.out.println("Product removed");
            } else {
                System.out.println("Product not removed");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again");
        }
    }

    private static void editProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Remove Product ===");
            System.out.print("Enter Id of the product: ");
            int id = scanner.nextInt();

            if (products.findById(id) != null) {
                System.out.print("Enter new name: ");
                String name = scanner.next();
                System.out.print("Enter new price: ");
                double price = scanner.nextDouble();
                products.editProduct(new Product(id, name, price));
            } else {
                System.out.println("Product not found");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again");
        }
    }

    private static void displayProducts() {
        System.out.println(products);
    }

    private static void sortProducts() {
        products.sortByPrice();
        System.out.println("Products sorted");
    }

    private static void findProductByName() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Find Product By Name ===");
            System.out.print("Enter Name: ");
            String name = scanner.next();

            Product result = products.findByName(name);
            if (result != null) {
                System.out.println("Product found: " + result);
            } else {
                System.out.println("Product not found");
            }

        } catch (Exception e) {
            System.out.println("Something went wrong, please try again");
        }
    }
}
