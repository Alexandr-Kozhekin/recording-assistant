package by.solmed.assistant.core.service.staffService;

import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.service.staffService.requests.DeleteStaffByNameRequest;
import by.solmed.assistant.core.service.staffService.responses.DeleteStaffByNameResponse;

public class DeleteStaffByNameService {

    private StaffDatabase database;

    public DeleteStaffByNameService(StaffDatabase database) {
        this.database = database;
    }

    public DeleteStaffByNameResponse execute(DeleteStaffByNameRequest request) {
        return new DeleteStaffByNameResponse(database.deleteStaffByName(request.getFirstName()));
    }
}
