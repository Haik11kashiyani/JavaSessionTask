package com.tss.test;

import com.tss.entitys.Box;

public class BoxTest
{
    public static void main(String[] args) {
        Box box=new Box();
//        box.initiation();
        System.out.println("with the default constructor size of box"+box.calculateArea());
        box.printAll();
        Box box2 =new Box(10,30,40);
        System.out.println("with the parameterized constructor size of box"+box2.calculateArea());
        box2.printAll();
    }
}
