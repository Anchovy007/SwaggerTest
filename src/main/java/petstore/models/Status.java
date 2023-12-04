package petstore.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status"})
public enum Status {

    available("available"),
    pending("pending"),
    sold("sold");

    private final String status;

    Status(String status) { this.status = status; }

    @Override
    public String toString() { return String.valueOf(status); }
}
