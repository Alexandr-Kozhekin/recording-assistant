package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProcedureDatabaseImpl implements ProcedureDatabase {

    private long procedureId = 0L;
    private List<Procedure> procedures;

    {
        procedures = new ArrayList<>();
        procedures.add(new Procedure(1L, "Test1", "Test1", 23.2F));
        procedures.add(new Procedure(2L, "Test2", "Test2", 40.40F));
        procedureId = procedures.size();
    }

    @Override
    public void saveProcedure(Procedure procedure) {
        procedureId++;
        procedure.setId(procedureId);
        procedures.add(procedure);
    }

    @Override
    public boolean deleteProcedureById(long id) {
        return procedures.removeIf(p -> p.getId() ==  id);
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
