package model;

import java.io.Serializable;

public class UsedService implements Serializable {
    private int id;
    private String service;
    private String pricePerUnit;
    private int quantilly;
    private float totalPrice;
    private int rentedCarlD;
    private int serviceID;
    private int rentingID;

    public UsedService() {
        super();
    }

    public UsedService(String service, String pricePerUnit, int quantilly, float totalPrice, int rentedCarlD, int serviceID, int rentingID) {
        super();
        this.service = service;
        this.pricePerUnit = pricePerUnit;
        this.quantilly = quantilly;
        this.totalPrice = totalPrice;
        this.rentedCarlD = rentedCarlD;
        this.serviceID = serviceID;
        this.rentingID = rentingID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getQuantilly() {
        return quantilly;
    }

    public void setQuantilly(int quantilly) {
        this.quantilly = quantilly;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRentedCarlD() {
        return rentedCarlD;
    }

    public void setRentedCarlD(int rentedCarlD) {
        this.rentedCarlD = rentedCarlD;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getRentingID() {
        return rentingID;
    }

    public void setRentingID(int rentingID) {
        this.rentingID = rentingID;
    }

    @Override
    public String toString() {
        return "UsedService{" +
               "id=" + id +
               ", service='" + service + '\'' +
               ", pricePerUnit='" + pricePerUnit + '\'' +
               ", quantilly=" + quantilly +
               ", totalPrice=" + totalPrice +
               ", rentedCarlD=" + rentedCarlD +
               ", serviceID=" + serviceID +
               ", rentingID=" + rentingID +
               '}';
    }
}
