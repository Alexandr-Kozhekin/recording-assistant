package by.solmed.assistant.dbTests;

import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.db.ProcedureDatabaseImpl;
import by.solmed.assistant.core.domain.Procedure;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcedureDatabaseImplTest {

    private ProcedureDatabase database;

    public ProcedureDatabaseImplTest() {
        database = new ProcedureDatabaseImpl();
    }

    @Before
    public void setUp() throws Exception {
        Procedure test1 = new Procedure("Test3","Test33",20.20F);
        Procedure test2 = new Procedure("Test4","Test44",15.15F);
        Procedure test3 = new Procedure("Test5","Test55",53.53F);
        Procedure test4 = new Procedure("Test6","Test66",26.26F);
        Procedure test5 = new Procedure("Test7","Test77",75.75F);
        database.saveProcedure(test1);
        database.saveProcedure(test2);
        database.saveProcedure(test3);
        database.saveProcedure(test4);
        database.saveProcedure(test5);
    }

    @Test
    public void addProcedureTest() {

        int expectedSize = database.findAllProcedures().size();

        Procedure procedure = new Procedure("Test", "Test",24.24F);
        database.saveProcedure(procedure);

        int actualSize = database.findAllProcedures().size();

        assertTrue(expectedSize < actualSize);
    }

    @Test
    public void deleteProcedureByIdTest() {

        int expectedSize = database.findAllProcedures().size();

        boolean actual = database.deleteProcedureById(3);

        int actualSize = database.findAllProcedures().size();

        assertTrue(actual);
        assertTrue(expectedSize > actualSize);
    }

    @Test
    public void findProcedureByIdTest() {

        Optional<Procedure> actualProcedure = database.findProcedureById(3);

        if(actualProcedure.isPresent()) {

            Procedure procedure = actualProcedure.get();

            Procedure expectedProcedure = new Procedure(3,"Test3","Test33",20.20F);

            assertEquals(expectedProcedure.getId(), procedure.getId());
            assertEquals(expectedProcedure.getName(), procedure.getName());
            assertEquals(expectedProcedure.getDescription(), procedure.getDescription());
            assertEquals(expectedProcedure.getTotalPrice(), procedure.getTotalPrice());

        } else {
            assertTrue(false, "Object not found!");
        }

    }

    @Test
    public void findAllProceduresTest() {

        List<Procedure> expected = Arrays.asList(
                new Procedure(1L,"Test1", "Test1", 23.2F),
                new Procedure(2L,"Test2", "Test2", 40.40F),
                new Procedure(3L,"Test3","Test33",20.20F),
                new Procedure(4L,"Test4","Test44",15.15F),
                new Procedure(5L,"Test5","Test55",53.53F),
                new Procedure(6L,"Test6","Test66",26.26F),
                new Procedure(7L,"Test7","Test77",75.75F)
        );

        List<Procedure> actual = database.findAllProcedures();

        assertEquals(actual, expected);
    }
}
