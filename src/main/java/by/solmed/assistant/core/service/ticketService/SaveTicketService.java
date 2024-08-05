package by.solmed.assistant.core.service.ticketService;

import by.solmed.assistant.core.db.TicketDatabase;
import by.solmed.assistant.core.domain.Ticket;

import java.util.Date;

import by.solmed.assistant.core.service.ticketService.requests.SaveTicketRequest;
import by.solmed.assistant.core.service.ticketService.responses.SaveTicketResponse;
import org.springframework.stereotype.Service;

@Service
public class SaveTicketService {

    private TicketDatabase database;

    public SaveTicketService(TicketDatabase database) {
        this.database = database;
    }

    public SaveTicketResponse execute(SaveTicketRequest request) {
        Ticket ticket = new Ticket(request.getClient(), request.getProcedures(),
                request.getStaff(), request.getDateAppointment());

        database.saveTicket(ticket);

        return new SaveTicketResponse(ticket);
    }

}
