package examen.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class CurrencyDto {

    @NotEmpty(message = "Cannot be empty")
    private String name;

    public CurrencyDto() {
    }

    public CurrencyDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
