package model;

import java.io.Serializable; // Import Serializable

// Lớp đại diện cho đối tượng Car (Xe ô tô) trong hệ thống
// Triển khai Serializable để có thể tuần tự hóa đối tượng (lưu trữ hoặc truyền qua mạng)
public class Car implements Serializable {
    private int id; // ID của xe (Integer)
    private String name; // Tên xe (varchar)
    private String type; // Loại xe (Sedan, SUV, Hatchback,...) (varchar)
    private float price; // Giá thuê xe mỗi ngày hoặc mỗi lần thuê (float)
    private String carLine; // Dòng xe (Camry, CRV, Morning,...) (varchar)
    private String fuelCondition; // Tình trạng nhiên liệu (Full, Half, Empty,...) (varchar)
    private String typeCondition; // Tình trạng chung của xe (Good, Fair, Poor,...) (varchar) - Lưu ý: Tên cột gốc là Type_Codition
    private String interiorCondition; // Tình trạng nội thất (Clean, Dirty, Damaged,...) (varchar) - Lưu ý: Tên cột gốc là Interior_codition
    private String damages; // Mô tả các hư hỏng (nếu có) (varchar)
    private int carRentalShopID; // ID của cửa hàng cho thuê xe mà xe này thuộc về (Integer) - Khóa ngoại

    // Constructor mặc định
    public Car() {
        super(); // Gọi constructor của lớp cha (Object)
    }

    // Constructor với các thuộc tính (không bao gồm ID, tương tự constructor của Room)
    public Car(String name, String type, float price, String carLine, String fuelCondition, String typeCondition, String interiorCondition, String damages, int carRentalShopID) {
        super(); // Gọi constructor của lớp cha (Object)
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

    // --- Getters và Setters cho các thuộc tính ---

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

    // Có thể thêm phương thức toString() để dễ dàng in thông tin đối tượng (tùy chọn)
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
