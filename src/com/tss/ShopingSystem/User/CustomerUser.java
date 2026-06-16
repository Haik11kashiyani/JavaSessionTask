package com.tss.ShopingSystem.User;

import com.tss.ShopingSystem.DataSource.database;
import com.tss.ShopingSystem.Product.products;
import com.tss.ShopingSystem.services.Users;

import java.util.HashMap;
import java.util.Map;

public class CustomerUser extends database implements Users {
    // Simple per-customer cart and order tracking
    private Map<Long, Integer> cart = new HashMap<>();
    private double lastOrderAmount = 0.0;
    private boolean orderPending = false;

    public CustomerUser() {
        super();
    }

    @Override
    public boolean loginUser(String uName, String password) {
        return customer.containsKey(uName) && customer.containsValue(password);
    }

    @Override
    public boolean createuser(String uName, String password) {
        if (loginUser(uName,password)){
            System.out.println("User already exists");
            return false;
        }
        else {
            customer.put(uName, password);
            System.out.println("user added... welcome"+uName);
            return true;
        }
    }

    // Customer-facing operations used by Navigater
    public void viewAllProducts() {
        viewAll();
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        double total = 0.0;
        System.out.println("-------------------- Your Cart --------------------");
        System.out.printf("| %-10s | %-20s | %-8s | %-8s | %-10s |\n", "ID", "Name", "Price", "Qty", "Subtotal");
        System.out.println("---------------------------------------------------");
        for (Map.Entry<Long, Integer> e : cart.entrySet()) {
            products p = findProductById(e.getKey());
            if (p == null) continue;
            int qty = e.getValue();
            double price = p.getProductPrice();
            double discount = p.getProductOFF();
            double subtotal = qty * price * (1 - discount / 100.0);
            total += subtotal;
            System.out.printf("| %-10d | %-20s | %-8.2f | %-8d | %-10.2f |\n",
                    p.getProductid(), p.getProductName(), price, qty, subtotal);
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("Total: $%.2f\n", total);
    }

    public void addToCart(int productId, int qty) {
        products p = findProductById(productId);
        if (p == null) {
            System.out.println("Invalid product id.");
            return;
        }
        if (qty <= 0) {
            System.out.println("Quantity must be at least 1.");
            return;
        }
        long id = p.getProductid();
        cart.put(id, cart.getOrDefault(id, 0) + qty);
        System.out.println("Added to cart: " + p.getProductName() + " x" + qty);
    }

    public void updateOrRemoveCartItem(int productId, int newQty) {
        products p = findProductById(productId);
        if (p == null) {
            System.out.println("Invalid product id.");
            return;
        }
        long id = p.getProductid();
        if (!cart.containsKey(id)) {
            System.out.println("This product is not in your cart.");
            return;
        }
        if (newQty <= 0) {
            cart.remove(id);
            System.out.println("Removed " + p.getProductName() + " from cart.");
        } else {
            cart.put(id, newQty);
            System.out.println("Updated " + p.getProductName() + " quantity to " + newQty);
        }
    }

    public boolean placeOrder() {
        if (cart.isEmpty()) return false;
        double total = 0.0;
        for (Map.Entry<Long, Integer> e : cart.entrySet()) {
            products p = findProductById(e.getKey());
            if (p == null) continue;
            int qty = e.getValue();
            double price = p.getProductPrice();
            double discount = p.getProductOFF();
            total += qty * price * (1 - discount / 100.0);
        }
        lastOrderAmount = total;
        orderPending = true;
        cart.clear();
        System.out.printf("Order placed. Amount due: $%.2f\n", lastOrderAmount);
        return true;
    }
}
