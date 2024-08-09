package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketDatabase {

    void saveTicket(Ticket ticket);
    boolean deleteTicketById(long id);
    Optional<Ticket> findTicketById(long id);
    List<Ticket> findAllTickets();

}
