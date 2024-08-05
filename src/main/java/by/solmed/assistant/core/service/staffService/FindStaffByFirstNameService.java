package by.solmed.assistant.core.service.staffService;

import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.domain.Staff;

import java.util.Optional;

public class FindStaffByFirstNameService {

    private StaffDatabase database;

    public FindStaffByFirstNameService(StaffDatabase database) {
        this.database = database;
    }

    public Staff execute(String firstName) {

        Optional<Staff> staff = database.findStaffByFirstName(firstName);

        return staff.isPresent() ? staff.get() : null;
    }
}
