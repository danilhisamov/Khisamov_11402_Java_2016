package sample.entity;


import java.io.Serializable;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class ClientEntity implements Serializable{
    private Integer id;


    private Integer rides_count;

    private Integer discount;


    private UserEntity user;

    private List<OrderEntity> orders;


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getRides_count() {
        return rides_count;
    }

    public void setRides_count(Integer rides_count) {
        this.rides_count = rides_count;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", rides_count=" + rides_count +
                ", discount=" + discount +
                ", user=" + user +
                '}';
    }
}
