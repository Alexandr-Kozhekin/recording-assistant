package by.solmed.assistant.core.service.ticketService.requests;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.domain.Staff;

import java.util.Date;
import java.util.List;

public class SaveTicketRequest {

    private Client client;
    private List<Procedure> procedures;
    private Staff staff;
    private Date dateAppointment;

    public SaveTicketRequest(Client client, List<Procedure> procedures, Staff staff, Date dateAppointment) {
        this.client = client;
        this.procedures = procedures;
        this.staff = staff;
        this.dateAppointment = dateAppointment;
    }

    public Client getClient() {
        return client;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public Staff getStaff() {
        return staff;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }
}
