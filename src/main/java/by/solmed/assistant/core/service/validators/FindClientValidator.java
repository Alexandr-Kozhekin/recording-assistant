package by.solmed.assistant.core.service.validators;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.db.ClientDatabaseImpl;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.requests.FindClientByNameRequest;
import by.solmed.assistant.core.service.clientService.requests.SaveClientRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindClientValidator {

    private ClientDatabase database;

    public FindClientValidator(ClientDatabase database) {
        this.database = database;
    }

    public List<CoreError> validate(FindClientByNameRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validFirstName(request).ifPresent(errors::add);
        validFind(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validFirstName(FindClientByNameRequest request) {
        if(request.getFirstName().matches("[0-9]")) {
            return Optional.of(new CoreError("Имя", "Имя не должно содержать цифры!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validFind(FindClientByNameRequest request) {

        Optional<Client> client = database.findClientByFirstName(request.getFirstName());

        if(client.isEmpty()) {
            return Optional.of(new CoreError("Клиент", "Клиент не найден!"));
        } else {
            return Optional.empty();
        }
    }

}
