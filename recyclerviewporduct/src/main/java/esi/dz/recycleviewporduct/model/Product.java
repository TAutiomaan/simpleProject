package esi.dz.recycleviewporduct.model;

import java.io.Serializable;



public class Product implements Serializable {
    private String name;
    private String price;
    private String description;
    private String size;
    private  int listImage;
    private int detailImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getListImage() {
        return listImage;
    }

    public void setListImage(int listImage) {
        this.listImage = listImage;
    }

    public int getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(int detailImage) {
        this.detailImage = detailImage;
    }

    public Product(String name, String price, String description, String size, int listImage, int detailImage) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
        this.listImage = listImage;
        this.detailImage = detailImage;
    }
}
