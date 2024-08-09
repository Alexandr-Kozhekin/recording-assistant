package by.solmed.assistant.dbTests;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.db.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClientDatabaseImplTest {

    private ClientDatabase database;

    public ClientDatabaseImplTest() {
        database = new ClientDatabaseImpl();
    }

    @Before
    public void setUp() throws Exception {
        Client test1 = new Client("Test3", "Test33", "Test", 13);
        Client test2 = new Client("Test4", "Test44", "Test", 15);
        Client test3 = new Client("Test5", "Test55", "Test", 53);
        Client test4 = new Client("Test6", "Test66", "Test", 26);
        Client test5 = new Client("Test7", "Test77", "Test", 75);
        database.saveClient(test1);
        database.saveClient(test2);
        database.saveClient(test3);
        database.saveClient(test4);
        database.saveClient(test5);
    }

    @Test
    public void addClientTest() {

        int expectedSize = database.findAllClient().size();

        Client client = new Client("Test", "Test", "Test", 24);
        database.saveClient(client);

        int actualSize = database.findAllClient().size();

        assertTrue(expectedSize < actualSize);
    }

    @Test
    public void deleteClientTest() {

        int expectedSize = database.findAllClient().size();

        boolean actual = database.deleteClientById(2L);

        int actualSize = database.findAllClient().size();

        assertTrue(actual);
        assertTrue(expectedSize > actualSize);
    }

    @Test
    public void findByClientFirstNameTest() {

        Optional<Client> actualClient = database.findClientByFirstName("Test3");

        if(actualClient.isPresent()) {

            Client client = actualClient.get();

            Client expectedClient = new Client(3L,"Test3", "Test33", "Test", 13);

            assertEquals(expectedClient.getId(), client.getId());
            assertEquals(expectedClient.getFirstName(), client.getFirstName());
            assertEquals(expectedClient.getLastName(), client.getLastName());
            assertEquals(expectedClient.getGender(), client.getGender());
            assertEquals(expectedClient.getAge(), client.getAge());

        } else {
            assertTrue(false, "Object not found!");
        }

    }

    @Test
    public void findAllClientsTest() {

        List<Client> expected = Arrays.asList(
                new Client(1L,"Test1", "Test1", "Test1", 13),
                new Client(2L,"Test2", "Test2", "Test2", 15),
                new Client(3L,"Test3", "Test33", "Test", 13),
                new Client(4L,"Test4", "Test44", "Test", 15),
                new Client(5L,"Test5", "Test55", "Test", 53),
                new Client(6L,"Test6", "Test66", "Test", 26),
                new Client(7L,"Test7", "Test77", "Test", 75)
        );

        List<Client> actual = database.findAllClient();

        assertEquals(actual, expected);
    }

}
