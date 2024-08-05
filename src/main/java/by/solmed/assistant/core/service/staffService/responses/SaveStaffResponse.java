package by.solmed.assistant.core.service.staffService.responses;

import by.solmed.assistant.core.domain.Staff;

public class SaveStaffResponse {

    public Staff staff;

    public SaveStaffResponse(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }
}
