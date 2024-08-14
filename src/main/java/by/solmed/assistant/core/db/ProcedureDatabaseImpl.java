package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Procedure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ProcedureDatabaseImpl implements ProcedureDatabase {

    private long procedureId = 0L;
    private List<Procedure> procedures = new ArrayList<>();
    private final String FILE_NAME = "src/main/java/by/solmed/assistant/saves/procedure_save.out";

    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            procedures = (List<Procedure>) ois.readObject();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveProcedure(Procedure procedure) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            procedureId++;
            procedure.setId(procedureId);
            procedures.add(procedure);
            oos.writeObject(procedures);
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public boolean deleteProcedureById(long id) {
        boolean result = procedures.removeIf(p -> p.getId() ==  id);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(procedures);
        } catch(Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public Optional<Procedure> findProcedureById(long id) {
        return procedures.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    @Override
    public List<Procedure> findAllProcedures() {
        return procedures;
    }
}
