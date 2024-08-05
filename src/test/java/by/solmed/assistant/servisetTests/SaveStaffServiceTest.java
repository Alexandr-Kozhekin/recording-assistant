package by.solmed.assistant.servisetTests;

import by.solmed.assistant.core.service.staffService.SaveStaffService;

import by.solmed.assistant.core.db.*;
import by.solmed.assistant.core.service.staffService.requests.SaveStuffRequest;
import by.solmed.assistant.core.service.staffService.responses.SaveStaffResponse;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveStaffServiceTest {

    private StaffDatabase database;
    private SaveStaffService saveStaffService;

    public SaveStaffServiceTest() {
        database = new StaffDatabaseImpl();
        saveStaffService = new SaveStaffService(database);
    }

    @Test
    public void testSaveStaffService() {

        SaveStuffRequest request = new SaveStuffRequest("Test6", "Test6", "Test6", 23,
                "Test6", "Test6", "Test6", "Test6", "Test6");

        int expectedSize = database.findAllStaff().size();

        SaveStaffResponse response = saveStaffService.execute(request);

        int actualSize = database.findAllStaff().size();

        assertTrue(expectedSize < actualSize);
    }

}