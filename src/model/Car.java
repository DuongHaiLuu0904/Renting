package model;

import java.io.Serializable; 

public class Car implements Serializable {
    private int id; 
    private String name; 
    private String type; 
    private float price; 
    private String carLine;
    private String fuelCondition; 
    private String typeCondition; 
    private String interiorCondition;
    private String damages; 
    private int carRentalShopID; 

   
    public Car() {
        super(); 
    }

   
    public Car(String name, String type, float price, String carLine, String fuelCondition, String typeCondition, String interiorCondition, String damages, int carRentalShopID) {
        super(); 
        this.name = name;
        this.type = type;
        this.price = price;
        this.carLine = carLine;
        this.fuelCondition = fuelCondition;
        this.typeCondition = typeCondition;
        this.interiorCondition = interiorCondition;
        this.damages = damages;
        this.carRentalShopID = carRentalShopID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCarLine() {
        return carLine;
    }

    public void setCarLine(String carLine) {
        this.carLine = carLine;
    }

    public String getFuelCondition() {
        return fuelCondition;
    }

    public void setFuelCondition(String fuelCondition) {
        this.fuelCondition = fuelCondition;
    }

    public String getTypeCondition() {
        return typeCondition;
    }

    public void setTypeCondition(String typeCondition) {
        this.typeCondition = typeCondition;
    }

    public String getInteriorCondition() {
        return interiorCondition;
    }

    public void setInteriorCondition(String interiorCondition) {
        this.interiorCondition = interiorCondition;
    }

    public String getDamages() {
        return damages;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

    public int getCarRentalShopID() {
        return carRentalShopID;
    }

    public void setCarRentalShopID(int carRentalShopID) {
        this.carRentalShopID = carRentalShopID;
    }

    @Override
    public String toString() {
        return "Car{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", type='" + type + '\'' +
               ", price=" + price +
               ", carLine='" + carLine + '\'' +
               ", fuelCondition='" + fuelCondition + '\'' +
               ", typeCondition='" + typeCondition + '\'' +
               ", interiorCondition='" + interiorCondition + '\'' +
               ", damages='" + damages + '\'' +
               ", carRentalShopID=" + carRentalShopID +
               '}';
    }
}
