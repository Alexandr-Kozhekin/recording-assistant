package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Staff;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class StaffDatabaseImpl implements StaffDatabase {

    private long staffId = 0L;
    private List<Staff> staff = new ArrayList<>();
    private final String FILE_NAME = "src/main/java/by/solmed/assistant/saves/staff_save.out";

    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            staff = (List<Staff>) ois.readObject();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveStaff(Staff stuff) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            staffId++;
            stuff.setId(staffId);
            staff.add(stuff);
            oos.writeObject(staff);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean deleteStaffByName(String firstNameStaff) {
        boolean result = staff.removeIf(s -> s.getFirstName().equals(firstNameStaff));
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(staff);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Optional<Staff> findStaffByFirstName(String firstName) {
        return staff.stream()
                .filter(s -> s.getFirstName().equals(firstName))
                .findFirst();
    }

    @Override
    public List<Staff> findAllStaff() {
        return staff;
    }
}
