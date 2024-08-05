package by.solmed.assistant.core.domain;

import java.util.Objects;

public class Сompound {

    private long id;
    private String name;
    private float price;

    public Сompound() {
    }

    public Сompound(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сompound сompound = (Сompound) o;
        return id == сompound.id && Float.compare(price, сompound.price) == 0 && Objects.equals(name, сompound.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Сompound{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}