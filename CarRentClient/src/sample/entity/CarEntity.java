package sample.entity;


import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class CarEntity {

    private Integer id;


    private String model;


    private Integer doors;

    private Integer seats;


    private String luggage;

    private String transmission;

    private String air_cond;

    private String photoPath;

    private Integer price;

    private String status;

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
