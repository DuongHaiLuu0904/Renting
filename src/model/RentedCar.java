package model;

import java.io.Serializable;
import java.sql.Date; // Using java.sql.Date for database date types

public class RentedCar implements Serializable {
    private int id;
    private Date carPickupDate;
    private Date carReturnDate;
    private float amount;
    private int carlD; // Corresponds to Car ID, keeping the original name
    private int rentingID;

    public RentedCar() {
        super();
    }

    public RentedCar(Date carPickupDate, Date carReturnDate, float amount, int carlD, int rentingID) {
        super();
        this.carPickupDate = carPickupDate;
        this.carReturnDate = carReturnDate;
        this.amount = amount;
        this.carlD = carlD;
        this.rentingID = rentingID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCarPickupDate() {
        return carPickupDate;
    }

    public void setCarPickupDate(Date carPickupDate) {
        this.carPickupDate = carPickupDate;
    }

    public Date getCarReturnDate() {
        return carReturnDate;
    }

    public void setCarReturnDate(Date carReturnDate) {
        this.carReturnDate = carReturnDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getCarlD() {
        return carlD;
    }

    public void setCarlD(int carlD) {
        this.carlD = carlD;
    }

    public int getRentingID() {
        return rentingID;
    }

    public void setRentingID(int rentingID) {
        this.rentingID = rentingID;
    }

    @Override
    public String toString() {
        return "RentedCar{" +
               "id=" + id +
               ", carPickupDate=" + carPickupDate +
               ", carReturnDate=" + carReturnDate +
               ", amount=" + amount +
               ", carlD=" + carlD +
               ", rentingID=" + rentingID +
               '}';
    }
}
