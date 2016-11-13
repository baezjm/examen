package examen.entity;

import examen.dto.MenuDto;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by jbaez on 11/10/16.
 */
@Entity(name = "menu")
public class Menu {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Digits(integer=5, fraction=2)
    @Column(name="price", nullable = false, precision = 7, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="currency")
    private Currency currency;

    @Temporal(TemporalType.DATE)
    @Column(name="from_valid_date", nullable = false)
    private Date fromValidDate;

    @Temporal(TemporalType.DATE)
    @Column(name="to_valid_date", nullable = false)
    private Date toValidDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "menu_day", joinColumns = @JoinColumn(name = "menu_id"))
    @Column(name="day")
    private List<String> days;

    @Column(name="from_hour", nullable = false)
    private Integer fromHour;

    @Column(name="from_minute", nullable = false)
    private Integer fromMinute;

    @Column(name="to_hour", nullable = false)
    private Integer toHour;

    @Column(name="to_minute", nullable = false)
    private Integer toMinute;

    @Column(name = "ranking", nullable = false)
    private Float ranking;

    @Column(name="picture_file", nullable = true)
    private String pictureFile;

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
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

    public String getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public Menu copyFrom(MenuDto menu) {
        if (menu.getName() != null) {
            this.name = menu.getName();
        }
        if (menu.getDescription() != null) {
            this.description = menu.getDescription();
        }
        if (menu.getPrice() != null) {
            this.price = menu.getPrice();
        }
        if (menu.getDays() != null) {
            this.days = menu.getDays();
        }
        if (menu.getFromHour() != null) {
            this.fromHour = menu.getFromHour();
        }
        if (menu.getFromMinute() != null) {
            this.fromMinute = menu.getFromMinute();
        }
        if (menu.getToHour() != null) {
            this.toHour = menu.getToHour();
        }
        if (menu.getToMinute() != null) {
            this.toMinute = menu.getToMinute();
        }
        if (menu.getFromValidDate() != null) {
            this.fromValidDate = menu.getFromValidDate();
        }
        if (menu.getToValidDate() != null) {
            this.toValidDate = menu.getToValidDate();
        }
        if (menu.getRanking() != null) {
            this.ranking = menu.getRanking();
        }
        if (menu.getPictureFile() != null) {
            this.pictureFile = menu.getPictureFile();
        }
        return this;
    }

}
