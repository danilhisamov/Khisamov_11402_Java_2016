package ru.kpfu.itis.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(targetEntity = CarEntity.class)
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @ManyToOne(targetEntity = ClientEntity.class)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(name = "pickUpLoc")
    private String pickUpLoc;

    @Column(name = "dropOffLoc")
    private String dropOffLoc;

    @Temporal(TemporalType.DATE)
    @Column(name = "pickUpDate")
    private Date pickUpDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dropOffDate")
    private Date dropOffDate;

    @Column(name = "pickUpTime")
    private String pickUpTime;

    @Column(name = "price")
    private Integer price;

    @Column(name = "dropOffTime")
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
