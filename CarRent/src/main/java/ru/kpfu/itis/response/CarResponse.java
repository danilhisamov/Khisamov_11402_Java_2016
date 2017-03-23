package ru.kpfu.itis.response;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class CarResponse {
    private Integer id;
    private String photoPath;
    private Integer price;
    private String model;
    private String luggage;
    private String transmission;
    private String air_cond;
    private Integer doors;
    private Integer seats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getAir_cond() {
        return air_cond;
    }

    public void setAir_cond(String air_cond) {
        this.air_cond = air_cond;
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
}
