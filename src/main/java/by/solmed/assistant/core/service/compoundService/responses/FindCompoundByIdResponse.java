package by.solmed.assistant.core.service.compoundService.responses;

import by.solmed.assistant.core.domain.Compound;

public class FindCompoundByIdResponse {

    private Compound compound;

    public FindCompoundByIdResponse(Compound compound) {
        this.compound = compound;
    }

    public Compound getCompound() {
        return compound;
    }
}
