package by.solmed.assistant.core.service.validators;

import java.util.List;

public class CoreResponse {

    private List<CoreError> errorList;

    public CoreResponse() {
    }

    public CoreResponse(List<CoreError> errorList) {
        this.errorList = errorList;
    }

    public List<CoreError> getErrorList() {
        return errorList;
    }

    public boolean hasError() {
        return errorList != null && !errorList.isEmpty();
    }
}
