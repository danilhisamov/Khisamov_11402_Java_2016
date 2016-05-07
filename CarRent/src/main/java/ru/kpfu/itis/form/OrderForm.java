package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class OrderForm {


    private Integer car_id;
    @NotEmpty
    private String pickUpLoc;

    private String dropOffLoc;


    private Date pickUpDate;
    private Date dropOffDate;

    @NotEmpty
    private String pickUpTime;
    @NotEmpty
    private String dropOffTime;

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
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

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }
}
