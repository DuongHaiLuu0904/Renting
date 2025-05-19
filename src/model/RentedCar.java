package model;

import java.io.Serializable;
import java.sql.Date;

public class RentedCar implements Serializable {
    private int id;
    private Date carPickupDate;
    private Date carReturnDate;
    private float amount;
    private int carId;       // Sửa lại tên biến cho đúng chuẩn
    private int rentingId;

    public RentedCar() {
        super();
    }

    public RentedCar(Date carPickupDate, Date carReturnDate, float amount, int carId, int rentingId) {
        super();
        this.carPickupDate = carPickupDate;
        this.carReturnDate = carReturnDate;
        this.amount = amount;
        this.carId = carId;
        this.rentingId = rentingId;
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

    public int getCarID() {
        return carId;
    }

    public void setCarID(int carId) {
        this.carId = carId;
    }

    public int getRentingId() {
        return rentingId;
    }

    public void setRentingId(int rentingId) {
        this.rentingId = rentingId;
    }

    @Override
    public String toString() {
        return "RentedCar{" +
               "id=" + id +
               ", carPickupDate=" + carPickupDate +
               ", carReturnDate=" + carReturnDate +
               ", amount=" + amount +
               ", carId=" + carId +
               ", rentingId=" + rentingId +
               '}';
    }
}
