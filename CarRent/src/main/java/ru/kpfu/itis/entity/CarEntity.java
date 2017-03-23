package ru.kpfu.itis.entity;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Entity
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "doors")
    private Integer doors;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "luggage")
    private String luggage;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "air_cond")
    private String air_cond;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    private String status;

    @OneToMany(targetEntity = OrderEntity.class,mappedBy = "car")
    private List<OrderEntity> orders;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

   public String getAir_cond() {
        return air_cond;
    }

    public void setAir_cond(String air_cond) {
        this.air_cond = air_cond;
    }

    public String getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", doors=" + doors +
                ", seats=" + seats +
                ", luggage='" + luggage + '\'' +
                ", transmission='" + transmission + '\'' +
                ", air_cond='" + air_cond + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
