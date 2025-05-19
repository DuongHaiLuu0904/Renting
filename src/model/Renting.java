package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Renting implements Serializable {

    private int id;
    private String promotion;
    private float totalAmount;
    private float deposit;
    private Client client;
    private RentalAgent rentalAgent;
    private ArrayList<RentedCar> rentedCars;

    public Renting() {
        super();
        rentedCars = new ArrayList<>();
    }

    public Renting(String promotion, float totalAmount, float deposit, Client client, RentalAgent rentalAgent, ArrayList<RentedCar> rentedCars) {
        super();
        this.promotion = promotion;
        this.totalAmount = totalAmount;
        this.deposit = deposit;
        this.client = client;
        this.rentalAgent = rentalAgent;
        this.rentedCars = rentedCars != null ? rentedCars : new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return client.getId();
    }

    public int getRentalAgentID() {
        return rentalAgent.getId();
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getDeposit() {
        return deposit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setClientID(int id) {
        if (this.client == null) {
            this.client = new Client();
        }
        this.client.setId(id);
    }

    public ArrayList<RentedCar> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(ArrayList<RentedCar> rentedCars) {
        this.rentedCars = rentedCars;
    }

    public void addRentedCar(RentedCar rentedCar) {
        if (this.rentedCars == null) {
            this.rentedCars = new ArrayList<>();
        }
        this.rentedCars.add(rentedCar);
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public void setRentalAgentID(int id) {
        if (this.rentalAgent == null) {
            this.rentalAgent = new RentalAgent(); // giả sử có constructor không tham số
        }
        this.rentalAgent.setId(id);
    }

    @Override
    public String toString() {
        return "Renting{"
                + "id=" + id
                + ", promotion='" + promotion + '\''
                + ", totalAmount=" + totalAmount
                + ", deposit=" + deposit
                + ", client=" + (client != null ? client.getName() : "null")
                + ", rentalAgent=" + (rentalAgent != null ? rentalAgent.getName() : "null")
                + ", rentedCars=" + (rentedCars != null ? rentedCars.size() : 0) + " items"
                + '}';
    }

}
