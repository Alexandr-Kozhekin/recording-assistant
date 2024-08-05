package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Client;
import by.solmed.assistant.core.domain.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffDatabase {

    void saveStaff(Staff stuff);
    boolean deleteStaffByName(String firstNameStaff);
    Optional<Staff> findStaffByFirstName(String firstName);
    List<Staff> findAllStaff();

}
