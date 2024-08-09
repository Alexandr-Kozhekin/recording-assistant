package by.solmed.assistant.dbTests;

import by.solmed.assistant.core.db.StaffDatabase;
import by.solmed.assistant.core.db.StaffDatabaseImpl;
import by.solmed.assistant.core.domain.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaffDatabaseImplTest {

    private StaffDatabase database;

    public StaffDatabaseImplTest() {
        database = new StaffDatabaseImpl();
    }

    @Before
    public void setUp() throws Exception {
        Staff test1 = new Staff("Test3", "Test33", "Test", 13);
        Staff test2 = new Staff("Test4", "Test44", "Test", 15);
        Staff test3 = new Staff("Test5", "Test55", "Test", 53);
        Staff test4 = new Staff("Test6", "Test66", "Test", 26);
        Staff test5 = new Staff("Test7", "Test77", "Test", 75);
        database.saveStaff(test1);
        database.saveStaff(test2);
        database.saveStaff(test3);
        database.saveStaff(test4);
        database.saveStaff(test5);
    }

    @Test
    public void addStaffTest() {

        int expectedSize = database.findAllStaff().size();

        Staff staff = new Staff("Test", "Test", "Test", 24);
        database.saveStaff(staff);

        int actualSize = database.findAllStaff().size();

        assertTrue(expectedSize < actualSize);
    }

    @Test
    public void deleteStaffByNameTest() {

        int expectedSize = database.findAllStaff().size();

        boolean actual = database.deleteStaffByName("Test3");

        int actualSize = database.findAllStaff().size();

        assertTrue(actual);
        assertTrue(expectedSize > actualSize);
    }

    @Test
    public void findByStaffFirstNameTest() {

        Optional<Staff> actualStaff = database.findStaffByFirstName("Test3");

        if(actualStaff.isPresent()) {

            Staff staff = actualStaff.get();

            Staff expectedStaff = new Staff(3L,"Test3", "Test33", "Test", 13);

            assertEquals(expectedStaff.getId(), staff.getId());
            assertEquals(expectedStaff.getFirstName(), staff.getFirstName());
            assertEquals(expectedStaff.getLastName(), staff.getLastName());
            assertEquals(expectedStaff.getGender(), staff.getGender());
            assertEquals(expectedStaff.getAge(), staff.getAge());

        } else {
            assertTrue(false, "Object not found!");
        }

    }

    @Test
    public void findAllStaffsTest() {

        List<Staff> expected = Arrays.asList(
                new Staff(1L,"Test1", "Test1", "Test1", 23),
                new Staff(2L,"Test2", "Test2", "Test2", 55),
                new Staff(3L,"Test3", "Test33", "Test", 13),
                new Staff(4L,"Test4", "Test44", "Test", 15),
                new Staff(5L,"Test5", "Test55", "Test", 53),
                new Staff(6L,"Test6", "Test66", "Test", 26),
                new Staff(7L,"Test7", "Test77", "Test", 75)
        );

        List<Staff> actual = database.findAllStaff();

        assertEquals(actual, expected);
    }

}
