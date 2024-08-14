package by.solmed.assistant.core.service.procedureService;

import by.solmed.assistant.core.db.CompoundDatabase;
import by.solmed.assistant.core.db.ProcedureDatabase;
import by.solmed.assistant.core.domain.Compound;
import by.solmed.assistant.core.domain.Procedure;
import by.solmed.assistant.core.service.procedureService.requests.SaveProcedureRequest;
import by.solmed.assistant.core.service.procedureService.responses.SaveProcedureResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaveProcedureService {

    private ProcedureDatabase procedureDatabase;
    private CompoundDatabase compoundDatabase;

    public SaveProcedureService(ProcedureDatabase procedureDatabase, CompoundDatabase compoundDatabase) {
        this.procedureDatabase = procedureDatabase;
        this.compoundDatabase = compoundDatabase;
    }

    public SaveProcedureResponse execute(SaveProcedureRequest request) {

        List<Compound> compoundList = new ArrayList<>();
        String[] ids = request.getMaterials().split(" ");

        if(request.getMaterials() != null && !request.getMaterials().isEmpty()) {
            for(String s : ids) {
                Optional<Compound> compound = compoundDatabase.findCompoundById(Long.parseLong(s));
                compound.ifPresent(compoundList::add);
            }
        }

        Procedure procedure = new Procedure(request.getName(), request.getDescription(),
                compoundList, Double.parseDouble(request.getPrice()));

        procedureDatabase.saveProcedure(procedure);

        return new SaveProcedureResponse(procedure);
    }

}
