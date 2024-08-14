package by.solmed.assistant.core.service.compoundService;

import by.solmed.assistant.core.db.CompoundDatabase;
import by.solmed.assistant.core.domain.Compound;
import by.solmed.assistant.core.service.compoundService.requests.SaveCompoundRequest;
import by.solmed.assistant.core.service.compoundService.responses.SaveCompoundResponse;

public class SaveCompoundService {

    private CompoundDatabase compoundDatabase;

    public SaveCompoundService(CompoundDatabase compoundDatabase) {
        this.compoundDatabase = compoundDatabase;
    }

    public SaveCompoundResponse execute(SaveCompoundRequest request) {

        Compound compound = new Compound(request.getName(), Double.parseDouble(request.getPrice()));

        compoundDatabase.saveCompound(compound);

        return new SaveCompoundResponse(compound);
    }

}