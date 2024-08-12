package by.solmed.assistant.core.service.validators;

import by.solmed.assistant.core.db.ClientDatabase;
import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.service.clientService.requests.DeleteClientByIdRequest;
import by.solmed.assistant.core.service.clientService.requests.FindClientByNameRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeleteClientByIdValidator {

    private ClientDatabase database;

    public DeleteClientByIdValidator(ClientDatabase database) {
        this.database = database;
    }

    public List<CoreError> validate(DeleteClientByIdRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validId(request).ifPresent(errors::add);
        validFind(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validId(DeleteClientByIdRequest request) {
        if(!String.valueOf(request.getId()).matches("-?\\d+(\\.\\d+)?")) {
            return Optional.of(new CoreError("Id клиента", "Id клиента должно содержать цифры!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validFind(DeleteClientByIdRequest request) {

        boolean client = database.deleteClientById(request.getId());

        if(!client) {
            return Optional.of(new CoreError("Клиент", "Клиент не найден!"));
        } else {
            return Optional.empty();
        }
    }

}
