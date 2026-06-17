package com.tss.ShopingSystem.User.Admin;

import com.tss.ShopingSystem.DataSource.database;
import com.tss.ShopingSystem.services.Users;

public class AdminUser extends database implements Users {
    public AdminUser() {
        super();
    }

    @Override
    public boolean loginUser(String uName,String password) {

        return admin.containsKey(uName) && admin.containsValue(password);

    }

    @Override
    public boolean createuser(String uName,String password) {
        if (loginUser(uName,password)) {
            System.out.println("User already exists");
            return false;
        }
        else {
            admin.put(uName, password);
            System.out.println("Admin added... welcome"+uName);
            return true;
        }
    }

}
