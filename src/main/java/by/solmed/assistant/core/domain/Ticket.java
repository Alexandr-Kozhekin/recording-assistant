package by.solmed.assistant.core.domain;

import java.io.Serializable;
import java.util.*;

public class Ticket implements Serializable {

    private long id;
    private Client client;
    private List<Procedure> procedures;
    private Staff staff;
    private Double totalPrice = 0.0D;
    private Date dateAt = new Date();
    private Date dateAppointment;

    public Ticket() {
    }

    public Ticket(Client client, List<Procedure> procedures, Staff staff, Date dateAppointment) {
        this.client = client;
        this.procedures = procedures;
        this.staff = staff;

        for(Procedure p : procedures)
            totalPrice += p.getTotalPrice();

        this.dateAppointment = dateAppointment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateAt() {
        return dateAt;
    }

    public void setDateAt(Date dateAt) {
        this.dateAt = dateAt;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Double.compare(totalPrice, ticket.totalPrice) == 0
                && Objects.equals(client, ticket.client)
                && Objects.equals(procedures, ticket.procedures)
                && Objects.equals(staff, ticket.staff)
                && Objects.equals(dateAt, ticket.dateAt)
                && Objects.equals(dateAppointment, ticket.dateAppointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, procedures, staff, totalPrice, dateAt, dateAppointment);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", client=" + client +
                ", procedures=" + procedures +
                ", staff=" + staff +
                ", totalPrice=" + totalPrice +
                ", dateAt=" + dateAt +
                ", dateAppointment=" + dateAppointment +
                '}';
    }
}
