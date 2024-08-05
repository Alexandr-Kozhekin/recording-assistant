package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientDatabase {

    void saveClient(Client client);
    boolean deleteClientById(long id);
    Optional<Client> findClientByFirstName(String firstName);
    List<Client> findAllClient();

}
