package com.tss.ShopingSystem.services;

import com.tss.ShopingSystem.Admin.AdminUser;
import com.tss.ShopingSystem.User.CustomerUser;

import static com.tss.Validation.ValidationForAll.inputInteger;
import static com.tss.Validation.ValidationForAll.inputString;

public class Navigater {

    public static void startSystem() {
        boolean mainApp = true;

        while (mainApp) {
            System.out.println("------------------Welcome to the Shopping System------------------");
            System.out.println("1.Admin Login \t 2.User/Customer Login \t 3.Exit the App");
            int choice = inputInteger();

            switch (choice) {
                case 1:
                    AdminUser adminUser = new AdminUser();
                    boolean tempAdmin = true;

                    while (tempAdmin) {
                        System.out.println("1.Create new Admin \t 2.Login Admin \t 3.Exit to Main Menu");
                        int adminchoice = inputInteger();
                        String uname, pass;

                        switch (adminchoice) {
                            case 1:
                                System.out.println("------------------Add Admin------------------");
                                System.out.println("Enter username:"); uname = inputString();
                                System.out.println("Enter password:"); pass = inputString();

                                if (adminUser.createuser(uname, pass)) {
                                    manageAdminOperations(adminUser);
                                } else {
                                    System.out.println("Registration failed.");
                                    tempAdmin = false;
                                }
                                break;

                            case 2:
                                System.out.println("------------------Admin Login------------------");
                                System.out.println("Enter username:"); uname = inputString();
                                System.out.println("Enter password:"); pass = inputString();

                                if (adminUser.loginUser(uname, pass)) {
                                    manageAdminOperations(adminUser);
                                } else {
                                    System.out.println("Invalid credentials.");
                                    tempAdmin = false;
                                }
                                break;

                            case 3:
                                tempAdmin = false;
                                break;

                            default:
                                System.out.println("invalid choice....");
                        }
                    }
                    break;

                case 2:
                    CustomerUser customerUser = new CustomerUser();
                    boolean tempCustomer = true;

                    while (tempCustomer) {
                        System.out.println("1.Create Customer Account \t 2.Login Customer \t 3.Exit to Main Menu");
                        int customerChoice = inputInteger();
                        String uname, pass;

                        switch (customerChoice) {
                            case 1:
                                System.out.println("------------------Customer Signup------------------");
                                System.out.println("Enter username:"); uname = inputString();
                                System.out.println("Enter password:"); pass = inputString();

                                if (customerUser.createuser(uname, pass)) {
                                    manageCustomerOperations(customerUser);
                                } else {
                                    System.out.println("Signup failed.");
                                    tempCustomer = false;
                                }
                                break;

                            case 2:
                                System.out.println("------------------Customer Login------------------");
                                System.out.println("Enter username:"); uname = inputString();
                                System.out.println("Enter password:"); pass = inputString();

                                if (customerUser.loginUser(uname, pass)) {
                                    manageCustomerOperations(customerUser);
                                } else {
                                    System.out.println("Invalid customer credentials.");
                                    tempCustomer = false;
                                }
                                break;

                            case 3:
                                tempCustomer = false;
                                break;

                            default:
                                System.out.println("invalid choice....");
                        }
                    }
                    break;

                case 3:
                    mainApp = false;
                    break;

                default:
                    System.out.println("invalid choice in menu");
            }
        }
    }

    // Extracted operations method for Admin management tasks
    private static void manageAdminOperations(AdminUser adminUser) {
        boolean worktemp = true;
        while (worktemp) {
            System.out.println("1.View Products \t 2.Updating Product \t 3.Add Product \t 4.Remove Product \t 5.Exit to Menu");
            int choiceOpration = inputInteger();

            switch (choiceOpration) {
                case 1: adminUser.viewAll(); break;
                case 2:
                    System.out.println("Product Id :"); int pid = inputInteger();
                    System.out.println("Product Name :"); String pname = inputString();
                    System.out.println("Product Price:"); double price = inputInteger();
                    System.out.println("Product Percentage Discount:"); double discount = inputInteger();
                    if (adminUser.updatingProductById(pid, price, discount, pname)) System.out.println("product updated...");
                    else System.out.println("invalid id.........");
                    break;
                case 3:
                    System.out.println("Product Name :"); String pname1 = inputString();
                    System.out.println("Product Price:"); double price1 = inputInteger();
                    System.out.println("Product Percentage Discount:"); double discount1 = inputInteger();
                    adminUser.addProduct(pname1, price1, discount1);
                    break;
                case 4:
                    System.out.println("Enter id of Product to delete"); int idprod = inputInteger();
                    if (adminUser.deleteProductById(idprod)) System.out.println("product deleted..");
                    else System.out.println("invalid id...");
                    break;
                case 5: worktemp = false; break;
                default: System.out.println("invalid operation.....");
            }
        }
    }

    // New extracted operations method for Customer shopping flows
    private static void manageCustomerOperations(CustomerUser customerUser) {
        boolean worktemp = true;
        while (worktemp) {
            System.out.println("\n--- Customer Operations ---");
            System.out.println("1.View All Products \t 2.View Cart \t 3.Add Product to Cart \t 4.Update/Remove Cart Item \t 5.Place Order  \t 6.Logout");
            int choiceOperation = inputInteger();

            switch (choiceOperation) {
                case 1:
                    customerUser.viewAllProducts();
                    break;

                case 2:
                    customerUser.viewCart();
                    break;

                case 3:
                    System.out.println("Enter Product ID to add to cart:");
                    int addId = inputInteger();
                    System.out.println("Enter quantity:");
                    int qty = inputInteger();
                    customerUser.addToCart(addId, qty);
                    break;

                case 4:
                    System.out.println("Enter Product ID to change/remove:");
                    int updateId = inputInteger();
                    System.out.println("Enter new quantity (0 to completely remove):");
                    int newQty = inputInteger();
                    customerUser.updateOrRemoveCartItem(updateId, newQty);
                    break;

                case 5:
                    if (customerUser.placeOrder()) {
                        System.out.println("Order created successfully! Please proceed to payment.");
                    } else {
                        System.out.println("Failed to place order. Is your cart empty?");
                    }
                    break;



                case 6:
                    worktemp = false;
                    System.out.println("Logged out from customer dashboard.");
                    break;

                default:
                    System.out.println("invalid operation.....");
            }
        }
    }
}
