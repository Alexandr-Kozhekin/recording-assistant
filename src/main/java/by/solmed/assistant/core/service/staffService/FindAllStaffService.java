package by.solmed.assistant.core.service.staffService;

import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.service.staffService.responses.FindAllStaffResponse;

public class FindAllStaffService {

    private StaffDatabase database;

    public FindAllStaffService(StaffDatabase database) {
        this.database = database;
    }

    public FindAllStaffResponse execute() {
        return new FindAllStaffResponse(database.findAllStaff());
    }
}
