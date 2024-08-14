package by.solmed.assistant.core.service.compoundService.responses;

import by.solmed.assistant.core.domain.Compound;

public class SaveCompoundResponse {

    private Compound compound;

    public SaveCompoundResponse(Compound compound) {
        this.compound = compound;
    }

    public Compound getCompound() {
        return compound;
    }
}
