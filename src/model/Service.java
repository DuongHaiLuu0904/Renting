package model;

import java.io.Serializable;

public class Service implements Serializable {
    private int id;
    private String name;
    private String unity;
    private float displayPrice;

    public Service() {
        super();
    }

    public Service(String name, String unity, float displayPrice) {
        super();
        this.name = name;
        this.unity = unity;
        this.displayPrice = displayPrice;
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

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public float getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(float displayPrice) {
        this.displayPrice = displayPrice;
    }

    @Override
    public String toString() {
        return "Service{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", unity='" + unity + '\'' +
               ", displayPrice=" + displayPrice +
               '}';
    }
}
