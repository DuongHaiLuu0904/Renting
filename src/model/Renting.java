package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Renting implements Serializable {
    private int id;
    private Date bookedDate;
    private String promotion;
    private float totalAmount;
    private float collateral;
    private int saleoff;
    private Client client;
    private RentalAgent rentalAgent;
    private ArrayList<RentedCar> rentedCars;

    public Renting() {
        super();
        rentedCars = new ArrayList<>();
    }

    public Renting(Date bookedDate, String promotion, float collateral, int saleoff, Client client, RentalAgent rentalAgent, ArrayList<RentedCar> rentedCars) {
        super();
        this.bookedDate = bookedDate;
        this.promotion = promotion;
        this.collateral = collateral;
        this.saleoff = saleoff;
        this.client = client;
        this.rentalAgent = rentalAgent;
        this.rentedCars = rentedCars;
        updateTotalAmount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public float getCollateral() {
        return collateral;
    }

    public void setCollateral(float collateral) {
        this.collateral = collateral;
    }

    public int getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(int saleoff) {
        this.saleoff = saleoff;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RentalAgent getRentalAgent() {
        return rentalAgent;
    }

    public void setRentalAgent(RentalAgent rentalAgent) {
        this.rentalAgent = rentalAgent;
    }

    public ArrayList<RentedCar> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(ArrayList<RentedCar> rentedCars) {
        this.rentedCars = rentedCars;
        updateTotalAmount();
    }

    public void addRentedCar(RentedCar rentedCar) {
        if (this.rentedCars == null) {
            this.rentedCars = new ArrayList<>();
        }
        this.rentedCars.add(rentedCar);
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        this.totalAmount = 0;
        if (this.rentedCars != null) {
            for (RentedCar rentedCar : this.rentedCars) {
                this.totalAmount += rentedCar.getAmount();
            }
        }
    }

    @Override
    public String toString() {
        return "Renting{" +
               "id=" + id +
               ", bookedDate=" + bookedDate +
               ", promotion='" + promotion + '\'' +
               ", totalAmount=" + totalAmount +
               ", collateral=" + collateral +
               ", saleoff=" + saleoff +
               ", client=" + (client != null ? client.getName() : "null") +
               ", rentalAgent=" + (rentalAgent != null ? rentalAgent.getName() : "null") +
               ", rentedCars=" + (rentedCars != null ? rentedCars.size() : "null") + " items" +
               '}';
    }
}
