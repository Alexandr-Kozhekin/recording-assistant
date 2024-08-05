package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDatabaseImpl implements TicketDatabase {

    private long ticketId = 0L;
    private List<Ticket> tickets;

    public TicketDatabaseImpl() {
        tickets = new ArrayList<>();
    }

    @Override
    public void saveTicket(Ticket ticket) {
        ticketId++;
        ticket.setId(ticketId);
        tickets.add(ticket);
    }

    @Override
    public boolean deleteTicketById(long id) {
        return tickets.removeIf(t -> t.getId() == id);
    }

    @Override
    public Optional<Ticket> findTicketById(long id) {
        return tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    @Override
    public List<Ticket> findAllTickets() {
        return tickets;
    }
}
