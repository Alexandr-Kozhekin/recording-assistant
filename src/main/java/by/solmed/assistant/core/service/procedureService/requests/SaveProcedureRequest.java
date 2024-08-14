package by.solmed.assistant.core.service.procedureService.requests;

public class SaveProcedureRequest {

    private String name;
    private String description;
    private String materials;
    private String price;

    public SaveProcedureRequest(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public SaveProcedureRequest(String name, String description, String materials, String price) {
        this.name = name;
        this.description = description;
        this.materials = materials;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMaterials() {
        return materials;
    }

    public String getPrice() {
        return price;
    }
}