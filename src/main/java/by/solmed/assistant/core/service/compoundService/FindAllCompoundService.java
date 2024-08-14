package by.solmed.assistant.core.service.compoundService;

import by.solmed.assistant.core.db.CompoundDatabase;
import by.solmed.assistant.core.service.compoundService.responses.FindAllCompoundResponse;

public class FindAllCompoundService {

    private CompoundDatabase database;

    public FindAllCompoundService(CompoundDatabase database) {
        this.database = database;
    }

    public FindAllCompoundResponse execute() {
        return new FindAllCompoundResponse(database.findAllCompounds());
    }
}
