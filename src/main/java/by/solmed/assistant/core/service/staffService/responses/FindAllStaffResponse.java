package by.solmed.assistant.core.service.staffService.responses;

import by.solmed.assistant.core.domain.Staff;

import java.util.List;

public class FindAllStaffResponse {

    private List<Staff> staffList;

    public FindAllStaffResponse(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }
}