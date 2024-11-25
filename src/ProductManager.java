import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        if (findById(product.getId()) == null) {
            products.add(product);
            return true;
        }
        return false;
    }

    public int removeProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return i;
            }
        }
        return -1;
    }

    public boolean editProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Product findById(int Id) {
        for (Product product : products) {
            if (product.getId() == Id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("=== List of Products ===\n");
        for (Product product : products) {
            s.append(product.toString()).append("\n");
        }
        return s.toString();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void sortByPrice() {
        for (int i = 1; i < products.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (products.get(j - 1).getPrice() > products.get(j).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j - 1));
                    products.set(j - 1, temp);
                }
            }
        }
    }
}
