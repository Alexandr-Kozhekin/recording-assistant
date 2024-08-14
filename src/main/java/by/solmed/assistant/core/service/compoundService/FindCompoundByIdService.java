package by.solmed.assistant.core.service.compoundService;

import by.solmed.assistant.core.db.CompoundDatabase;
import by.solmed.assistant.core.domain.Compound;
import by.solmed.assistant.core.service.compoundService.requests.FindCompoundByIdRequest;
import by.solmed.assistant.core.service.compoundService.responses.FindCompoundByIdResponse;

import java.util.Optional;

public class FindCompoundByIdService {

    private CompoundDatabase database;

    public FindCompoundByIdService(CompoundDatabase database) {
        this.database = database;
    }

    public FindCompoundByIdResponse execute(FindCompoundByIdRequest request) {

        Optional<Compound> compound = database.findCompoundById(Long.parseLong(request.getId()));

        return compound.map(FindCompoundByIdResponse::new).orElse(null);
    }
}
