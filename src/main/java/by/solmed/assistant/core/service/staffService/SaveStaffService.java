package by.solmed.assistant.core.service.staffService;

import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.domain.Staff;
import by.solmed.assistant.core.service.staffService.requests.SaveStuffRequest;
import by.solmed.assistant.core.service.staffService.responses.SaveStaffResponse;

public class SaveStaffService {

    private StaffDatabase database;

    public SaveStaffService(StaffDatabase database) {
        this.database = database;
    }

    public SaveStaffResponse execute(SaveStuffRequest request) {

        Staff staff = new Staff(request.getFirstName(), request.getLastName(), request.getGender(), request.getAge(),
                request.getMajor(), request.getSubdivision(), request.getExperience(), request.getCategory(),
                request.getType());

        database.saveStaff(staff);

        return new SaveStaffResponse(staff);
    }

}
