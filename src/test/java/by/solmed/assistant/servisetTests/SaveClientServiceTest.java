package by.solmed.assistant.servisetTests;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.db.ClientDatabaseImpl;
import by.solmed.assistant.core.service.clientService.SaveClientService;
import by.solmed.assistant.core.service.clientService.requests.SaveClientRequest;
import by.solmed.assistant.core.service.clientService.responses.SaveClientResponse;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveClientServiceTest {

    private ClientDatabase database;
    private SaveClientService saveClientService;

    public SaveClientServiceTest() {
        database = new ClientDatabaseImpl();
        saveClientService = new SaveClientService(database);
    }

    @Test
    public void saveClientServiceTest() {

        SaveClientRequest request = new SaveClientRequest(
                "Test6", "Test6", "Test6", 23,
                "+123(12)12312123", "Test6.Test6@Test6",
                "Test6", "Test6", "Test6", "Test6");

        int expectedSize = database.findAllClient().size();

        SaveClientResponse response = saveClientService.execute(request);

        int actualSize = database.findAllClient().size();

        assertTrue(expectedSize < actualSize);
    }

}
