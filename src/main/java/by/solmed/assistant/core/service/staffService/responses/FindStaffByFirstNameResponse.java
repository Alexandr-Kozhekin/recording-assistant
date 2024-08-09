package by.solmed.assistant.core.service.staffService.responses;

import by.solmed.assistant.core.domain.Staff;

public class FindStaffByFirstNameResponse {

    private Staff staff;

    public FindStaffByFirstNameResponse(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }
}