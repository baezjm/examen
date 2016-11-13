package examen.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PriceDto {

    @NotNull(message = "The price cannot be null")
    private Float priceFrom;

    @NotNull(message = "The price cannot be null")
    private Float priceTo;

    @NotNull(message = "Id cannot be null")
    @Min(value=1, message = "Id cannot be null")
    private Long currencyId;

    public PriceDto() {
    }

    public Float getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Float priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Float getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Float priceTo) {
        this.priceTo = priceTo;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

}
