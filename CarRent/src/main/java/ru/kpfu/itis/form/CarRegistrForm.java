package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Pattern;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class CarRegistrForm {
    @NotEmpty
    private String model;

    @NotEmpty
    private String air_cond;

    @NotEmpty
    private String luggage;

    private Integer doors;

    private Integer seats;

    private Integer price;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @NotEmpty
    @Pattern(regexp = "(Automatic)|(Mechanic)")
    private String transmission;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAir_cond() {
        return air_cond;
    }

    public void setAir_cond(String air_cond) {
        this.air_cond = air_cond;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
