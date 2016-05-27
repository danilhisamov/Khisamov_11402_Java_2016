package sample.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author Danil Khisamov
 *         11-402
 */

public class OrderEntity implements Serializable{

    private Integer id;


    private CarEntity car;


    private ClientEntity client;

    private String pickUpLoc;

    private String dropOffLoc;


    private Date pickUpDate;


    private Date dropOffDate;


    private String pickUpTime;

    private Integer price;


    private String  dropOffTime;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
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
}
