package by.solmed.assistant.core.db;

import by.solmed.assistant.core.domain.Compound;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompoundDatabaseImpl implements CompoundDatabase {

    private long compoundId = 0L;
    private List<Compound> compounds = new ArrayList<>();
    private final String FILE_NAME = "src/main/java/by/solmed/assistant/saves/compound_save.out";

    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            compounds = (List<Compound>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void saveCompound(Compound compound) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            compoundId++;
            compound.setId(compoundId);
            compounds.add(compound);
            oos.writeObject(compounds);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean deleteCompoundById(long id) {
        boolean result = compounds.removeIf(c -> c.getId() == id);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(compounds);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Optional<Compound> findCompoundById(long id) {
        return compounds.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public List<Compound> findAllCompounds() {
        return compounds;
    }
}