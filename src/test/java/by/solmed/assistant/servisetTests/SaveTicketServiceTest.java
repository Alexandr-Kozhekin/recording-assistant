package by.solmed.assistant.servisetTests;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.domain.Staff;
import by.solmed.assistant.core.service.ticketService.SaveTicketService;
import by.solmed.assistant.core.db.*;

import java.util.Arrays;
import java.util.Date;

import by.solmed.assistant.core.service.ticketService.requests.SaveTicketRequest;
import by.solmed.assistant.core.service.ticketService.responses.SaveTicketResponse;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveTicketServiceTest {

    private TicketDatabase database;
    private SaveTicketService saveTicketService;

    public SaveTicketServiceTest() {
        database = new TicketDatabaseImpl();
        saveTicketService = new SaveTicketService(database);
    }

    @Test
    public void saveTickerServiceTest() {
        SaveTicketRequest request = new SaveTicketRequest(new Client(), Arrays.asList(
                new Procedure("Test1", "Test1", 1F),
                new Procedure("Test2", "Test2", 2F),
                new Procedure("Test3", "Test3", 3F))
                , new Staff(), new Date());

        int expectedSize = database.findAllTickets().size();

        SaveTicketResponse response = saveTicketService.execute(request);

        int actualSize = database.findAllTickets().size();

        assertTrue(expectedSize < actualSize);

    }
}
