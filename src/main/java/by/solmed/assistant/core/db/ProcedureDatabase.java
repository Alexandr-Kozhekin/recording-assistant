package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface ProcedureDatabase {

    void saveProcedure(Procedure procedure);
    boolean deleteProcedureById(long id);
    Optional<Procedure> findProcedureById(long id);
    List<Procedure> findAllProcedures();

}
