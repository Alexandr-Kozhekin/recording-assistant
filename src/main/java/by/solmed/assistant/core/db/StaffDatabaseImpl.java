package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.domain.Staff;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StaffDatabaseImpl implements StaffDatabase {

    private long staffId = 0L;
    private List<Staff> staffList;

    {
        staffList = new ArrayList<>();
        staffList.add(new Staff(1L,"Test1", "Test1", "Test1", 23));
        staffList.add(new Staff(2L,"Test2", "Test2", "Test2", 55));
        staffId = staffList.size();
    }

    @Override
    public void saveStaff(Staff stuff) {
        staffId++;
        stuff.setId(staffId);
        staffList.add(stuff);
    }

    @Override
    public boolean deleteStaffByName(String firstNameStaff) {
        return staffList.removeIf(s -> s.getFirstName().equals(firstNameStaff));
    }

    @Override
    public Optional<Staff> findStaffByFirstName(String firstName) {
        return staffList.stream()
                .filter(s -> s.getFirstName().equals(firstName))
                .findFirst();
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffList;
    }
}
