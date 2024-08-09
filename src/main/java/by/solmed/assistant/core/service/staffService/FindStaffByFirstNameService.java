package by.solmed.assistant.core.service.staffService;

import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.domain.Staff;
import by.solmed.assistant.core.service.staffService.requests.FindStaffByFirstNameRequest;
import by.solmed.assistant.core.service.staffService.responses.FindStaffByFirstNameResponse;

import java.util.Optional;

public class FindStaffByFirstNameService {

    private StaffDatabase database;

    public FindStaffByFirstNameService(StaffDatabase database) {
        this.database = database;
    }

    public FindStaffByFirstNameResponse execute(FindStaffByFirstNameRequest request) {

        Optional<Staff> staff = database.findStaffByFirstName(request.getFirstName());

        return staff.map(FindStaffByFirstNameResponse::new).orElse(null);
    }
}
