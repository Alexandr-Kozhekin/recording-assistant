package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Compound;
import by.solmed.assistant.core.domain.Procedure;

import java.util.List;
import java.util.Optional;

public interface CompoundDatabase {

    void saveCompound(Compound procedure);
    boolean deleteCompoundById(long id);
    Optional<Compound> findCompoundById(long id);
    List<Compound> findAllCompounds();

}
