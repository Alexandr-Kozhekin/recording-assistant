package by.solmed.assistant.core.domain;

import java.io.Serializable;
import java.util.Objects;

public class Compound implements Serializable {

    private long id;
    private String name;
    private Double price;

    public Compound() {
    }

    public Compound(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Compound(long id, String name, Double price) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compound compound = (Compound) o;
        return id == compound.id && Double.compare(price, compound.price) == 0 && Objects.equals(name, compound.name);
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