package ru.kpfu.itis.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Entity
@Table(name = "clients")
public class ClientEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "foreign")
    @GenericGenerator(name = "foreign", strategy = "foreign", parameters =
            {@org.hibernate.annotations.Parameter(name = "property", value = "user")}
    )
    @Column(name = "id")
    private Integer id;

    @Column(name = "rides_count", nullable = false)
    private Integer rides_count;

    @Column(name = "discount",nullable = false)
    private Integer discount;

    @OneToOne(targetEntity = UserEntity.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @MapsId
    private UserEntity user;

    @OneToMany(targetEntity = OrderEntity.class,mappedBy = "client")
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
