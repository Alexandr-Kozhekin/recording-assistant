package by.solmed.assistant.core.service.ticketService.responses;

import by.solmed.assistant.core.domain.Ticket;

public class SaveTicketResponse {

    private Ticket ticket;

    public SaveTicketResponse(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
