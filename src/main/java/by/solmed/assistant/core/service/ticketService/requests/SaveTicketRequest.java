package by.solmed.assistant.core.service.ticketService.requests;

import java.util.List;

public class SaveTicketRequest {

    private String clientFirstName;
    private List<Long> idList;
    private String staffFirstName;
    private String dateAppointment;

    public SaveTicketRequest(String clientFirstName, List<Long> idList, String staffFirstName, String dateAppointment) {
        this.clientFirstName = clientFirstName;
        this.idList = idList;
        this.staffFirstName = staffFirstName;
        this.dateAppointment = dateAppointment;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public String getStaffFirstName() {
        return staffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName = staffFirstName;
    }

    public String getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(String dateAppointment) {
        this.dateAppointment = dateAppointment;
    }
}
