package model;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String name;
    private String cccd;
    private String address;
    private String phoneNumber;
    private String email;
    private String note;

    public Client() {
        super();
    }

    public Client(String name, String cccd, String address, String phoneNumber, String email, String note) {
        super();
        this.name = name;
        this.cccd = cccd;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.note = note;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Client{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", cccd='" + cccd + '\'' +
               ", address='" + address + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", email='" + email + '\'' +
               ", note='" + note + '\'' +
               '}';
    }
}
