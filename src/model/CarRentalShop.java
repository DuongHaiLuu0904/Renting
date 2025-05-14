package model;

import java.io.Serializable;

public class CarRentalShop implements Serializable {
    private int id;
    private String name;
    private String address;
    private int carlD;

    public CarRentalShop() {
        super();
    }

    public CarRentalShop(String name, String address, int carlD) {
        super();
        this.name = name;
        this.address = address;
        this.carlD = carlD;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCarlD() {
        return carlD;
    }

    public void setCarlD(int carlD) {
        this.carlD = carlD;
    }

    @Override
    public String toString() {
        return "CarRentalShop{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", address='" + address + '\'' +
               ", carlD=" + carlD +
               '}';
    }
}
