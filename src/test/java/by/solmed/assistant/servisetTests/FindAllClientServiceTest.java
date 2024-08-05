package by.solmed.assistant.servisetTests;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.FindAllClientService;
import by.solmed.assistant.core.service.clientService.responses.FindAllClientResponse;
import by.solmed.assistant.core.db.*;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindAllClientServiceTest {

    private ClientDatabase database;
    private FindAllClientService findAllClientService;

    public FindAllClientServiceTest() {
        database = new ClientDatabaseImpl();
        findAllClientService = new FindAllClientService(database);
    }

    @Before
    public void setUp() throws Exception {
        Client test1 = new Client("Test1", "Test11", "Test", 13);
        Client test2 = new Client("Test2", "Test22", "Test", 15);
        Client test3 = new Client("Test3", "Test33", "Test", 53);
        Client test4 = new Client("Test4", "Test44", "Test", 26);
        Client test5 = new Client("Test5", "Test55", "Test", 75);
        database.saveClient(test1);
        database.saveClient(test2);
        database.saveClient(test3);
        database.saveClient(test4);
        database.saveClient(test5);
    }

    @Test
    public void findAllClientServiceTest() {

        Client test1 = new Client(1L,"Test1", "Test1", "Test1", 13);
        Client test5 = new Client(7L,"Test5", "Test55", "Test", 75);

        int expectedSize = 0;

        FindAllClientResponse response = findAllClientService.execute();

        int actualSize = response.getClients().size();

        assertTrue(expectedSize < actualSize);

        assertEquals(test1.getId(), response.getClients().get(0).getId());
        assertEquals(test1.getFirstName(), response.getClients().get(0).getFirstName());
        assertEquals(test1.getLastName(), response.getClients().get(0).getLastName());
        assertEquals(test1.getGender(), response.getClients().get(0).getGender());
        assertEquals(test1.getAge(), response.getClients().get(0).getAge());

        assertEquals(test5.getId(), response.getClients().get(6).getId());
        assertEquals(test5.getFirstName(), response.getClients().get(6).getFirstName());
        assertEquals(test5.getLastName(), response.getClients().get(6).getLastName());
        assertEquals(test5.getGender(), response.getClients().get(6).getGender());
        assertEquals(test5.getAge(), response.getClients().get(6).getAge());
    }
}
