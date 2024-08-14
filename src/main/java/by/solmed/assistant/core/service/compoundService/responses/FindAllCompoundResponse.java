package by.solmed.assistant.core.service.compoundService.responses;

import by.solmed.assistant.core.domain.Compound;

import java.util.List;

public class FindAllCompoundResponse {

    private List<Compound> compounds;

    public FindAllCompoundResponse(List<Compound> compounds) {
        this.compounds = compounds;
    }

    public List<Compound> getCompounds() {
        return compounds;
    }
}
