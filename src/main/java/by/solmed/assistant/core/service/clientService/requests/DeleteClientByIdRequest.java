package by.solmed.assistant.core.service.clientService.requests;

public class DeleteClientByIdRequest {

    private long id;

    public DeleteClientByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
