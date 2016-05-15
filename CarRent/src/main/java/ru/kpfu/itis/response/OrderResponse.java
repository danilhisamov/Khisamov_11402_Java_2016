package ru.kpfu.itis.response;

import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.entity.ClientEntity;

import java.util.Date;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class OrderResponse {
    private Integer id;

    private String car;

    private String client;

    private String pickUpLoc;

    private String dropOffLoc;

    private String pickUpDate;

    private String dropOffDate;

    private String pickUpTime;

    private Integer price;

    private String  dropOffTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPickUpLoc() {
        return pickUpLoc;
    }

    public void setPickUpLoc(String pickUpLoc) {
        this.pickUpLoc = pickUpLoc;
    }

    public String getDropOffLoc() {
        return dropOffLoc;
    }

    public void setDropOffLoc(String dropOffLoc) {
        this.dropOffLoc = dropOffLoc;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }
}
