package by.solmed.assistant.core.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Procedure implements Serializable {

    private long id;
    private String name;
    private String description;
    private List<Compound> materials;
    private Double totalPrice;

    public Procedure(String name, String description, Double totalPrice) {
        this.name = name;
        this.description = description;
        this.totalPrice = totalPrice;
    }

    public Procedure(long id, String name, String description, Double totalPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalPrice = totalPrice;
    }

    public Procedure(String name, String description, List<Compound> materials, Double totalPrice) {
        this.name = name;
        this.description = description;
        this.materials = materials;

        for(Compound c : materials)
            totalPrice += (c.getPrice() * (((double) 25 / 100) + 1));

        this.totalPrice = totalPrice;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Compound> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Compound> materials) {
        this.materials = materials;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return id == procedure.id && Objects.equals(name, procedure.name)
                && Objects.equals(description, procedure.description)
                && Objects.equals(materials, procedure.materials)
                && Objects.equals(totalPrice, procedure.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, materials, totalPrice);
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", materials=" + materials +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
