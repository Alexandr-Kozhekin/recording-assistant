package by.solmed.assistant.core.domain;

import java.util.List;
import java.util.Objects;

public class Procedure {

    private long id;
    private String name;
    private String description;
    private List<Сompound> materials;
    private float totalPrice = 0.0F;

    public Procedure(String name, String description, float totalPrice) {
        this.name = name;
        this.description = description;
        this.totalPrice = totalPrice;
    }

    public Procedure(long id, String name, String description, float totalPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalPrice = totalPrice;
    }

    public Procedure(String name, String description, List<Сompound> materials) {
        this.name = name;
        this.description = description;
        this.materials = materials;

        for(Сompound c : materials)
            totalPrice += (c.getPrice() * ((float) 100 / 25));
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

    public List<Сompound> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Сompound> materials) {
        this.materials = materials;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return id == procedure.id && Float.compare(totalPrice, procedure.totalPrice) == 0 && Objects.equals(name, procedure.name) && Objects.equals(description, procedure.description) && Objects.equals(materials, procedure.materials);
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
