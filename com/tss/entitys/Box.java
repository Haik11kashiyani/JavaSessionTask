package com.tss.entitys;

public class Box {
    protected double width;
    protected double height;
    protected double depth;
    public Box()
    {
        width=10;
        depth=20;
        height=30;
    }
    public Box(double depth,double width,double height)
    {
        this.depth=depth;
        this.width=width;
        this.height=height;
    }
    public double calculateArea()
    {
        return width*height*depth;
    }
    public void printAll()
    {
        System.out.println("width :"+width +"\n hieght : "+height+"\n depth :"+depth);
    }
    public void initiation()
    {
        width=10;
        depth=20;
        height=30;
    }

}
