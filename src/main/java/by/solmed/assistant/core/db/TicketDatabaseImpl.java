package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Ticket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class TicketDatabaseImpl implements TicketDatabase {

    private long ticketId = 0L;
    private List<Ticket> tickets = new ArrayList<>();
    private final String FILE_NAME = "src/main/java/by/solmed/assistant/saves/ticket_save.out";

    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tickets = (List<Ticket>) ois.readObject();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveTicket(Ticket ticket) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            ticketId++;
            ticket.setId(ticketId);
            tickets.add(ticket);
            oos.writeObject(tickets);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean deleteTicketById(long id) {
        boolean result = tickets.removeIf(t -> t.getId() == id);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tickets);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
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
