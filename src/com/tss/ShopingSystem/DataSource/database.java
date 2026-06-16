package com.tss.ShopingSystem.DataSource;

import com.tss.ShopingSystem.Product.products;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class database {
    static int counter = 0;
    protected int id;

    // CRITICAL: Changed to static so all instances share the same data memory
    protected static Map<String, String> admin = new HashMap<>();
    protected static Map<String, String> customer = new HashMap<>();
    protected static ArrayList<products> productList = new ArrayList<>();

    public database() {
        this.id = counter++;
    }

    public int getId() { return id; }
    public Map<String, String> getAdmin() { return admin; }
    public Map<String, String> getCustomer() { return customer; }

    // Helper method to find a product by its unique ID
    public static products findProductById(long id) {
        for (products p : productList) {
            if (p.getProductid() == id) {
                return p;
            }
        }
        return null;
    }

    public void viewAll() {
        if (productList.isEmpty()) {
            System.out.println("No products available in the store right now.");
            return;
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-12s | %-10s |\n", "ID", "Product Name", "Price ($)", "Discount %");
        System.out.println("-----------------------------------------------------------------");
        for (products p : productList) {
            System.out.printf("| %-10d | %-20s | %-12.2f | %-10.1f |\n",
                    p.getProductid(), p.getProductName(), p.getProductPrice(), p.getProductOFF());
        }
        System.out.println("-----------------------------------------------------------------");
    }

    public void addProduct(String pname, double price, double discount) {
        products newProduct = new products(pname, price, discount);
        productList.add(newProduct);
        System.out.println("Product added successfully with ID: " + newProduct.getProductid());
    }

    public boolean deleteProductById(long targetId) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductid() == targetId) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updatingProductById(long targetId, double price, double discount, String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductid() == targetId) {
                productList.get(i).setProductName(name);
                productList.get(i).setProductPrice(price);
                productList.get(i).setProductOFF(discount);
                return true;
            }
        }
        return false;
    }
}
