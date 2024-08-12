package by.solmed.assistant.core.service.clientService.responses;

import by.solmed.assistant.core.service.validators.CoreError;
import by.solmed.assistant.core.service.validators.CoreResponse;

import java.util.List;

public class DeleteClientByIdResponse extends CoreResponse {

    private boolean response;

    public DeleteClientByIdResponse(List<CoreError> errorList) {
        super(errorList);
    }

    public DeleteClientByIdResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
