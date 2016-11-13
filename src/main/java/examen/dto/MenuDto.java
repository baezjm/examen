package examen.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MenuDto {

    @NotEmpty(message = "Cannot be empty")
    private String name;

    @NotEmpty(message = "Cannot be empty")
    private String description;

    @Min(value = 0, message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Id cannot be null")
    @Min(value=1, message = "Id cannot be null")
    private Long currencyId;

    @NotNull(message = "The date cannot be null")
    private Date fromValidDate;

    @NotNull(message = "The date cannot be null")
    private Date toValidDate;

    @Range(min = 0, max = 23, message = "Hour must be between 0 and 23")
    private Integer fromHour;

    @Range(min = 0, max = 59, message = "Minute must be between 0 and 59")
    private Integer fromMinute;

    @Range(min = 0, max = 23, message = "Hour must be between 0 and 23")
    private Integer toHour;

    @Range(min = 0, max = 59, message = "Minute must be between 0 and 59")
    private Integer toMinute;

    @Range(min=0, max= 5, message = "Ranking must be between 0 and 5")
    private Float ranking;

    @NotNull(message = "The days list cannot be null")
    private List<String> days;

    private String pictureFile;

    public MenuDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Date getFromValidDate() {
        return fromValidDate;
    }

    public void setFromValidDate(Date fromValidDate) {
        this.fromValidDate = fromValidDate;
    }

    public Date getToValidDate() {
        return toValidDate;
    }

    public void setToValidDate(Date toValidDate) {
        this.toValidDate = toValidDate;
    }

    public Integer getFromHour() {
        return fromHour;
    }

    public void setFromHour(Integer fromHour) {
        this.fromHour = fromHour;
    }

    public Integer getFromMinute() {
        return fromMinute;
    }

    public void setFromMinute(Integer fromMinute) {
        this.fromMinute = fromMinute;
    }

    public Integer getToHour() {
        return toHour;
    }

    public void setToHour(Integer toHour) {
        this.toHour = toHour;
    }

    public Integer getToMinute() {
        return toMinute;
    }

    public void setToMinute(Integer toMinute) {
        this.toMinute = toMinute;
    }

    public Float getRanking() {
        return ranking;
    }

    public void setRanking(Float ranking) {
        this.ranking = ranking;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public String getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(String pictureFile) {
        this.pictureFile = pictureFile;
    }
}
