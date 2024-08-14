package by.solmed.assistant.core.service.compoundService.requests;

public class SaveCompoundRequest {

    private String name;
    private String price;

    public SaveCompoundRequest(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}