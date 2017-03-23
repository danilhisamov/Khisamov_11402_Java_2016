package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entity.OrderEntity;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findAllByClient_id(Integer id);
    List<OrderEntity> findAllByCar_id(Integer id);
    List<OrderEntity> findAll();

    @Query(value = "select * from orders o where current_date between o.pickupdate and o.dropoffdate",
            nativeQuery=true
    )
    List<OrderEntity> findAllCurrentOrders();

    @Query(value = "select * from orders o where current_date > o.dropoffdate",
            nativeQuery=true
    )
    List<OrderEntity> findAllPastOrders();

    @Query(value = "select * from orders o where current_date < o.pickupdate",
            nativeQuery=true
    )
    List<OrderEntity> findAllFutureOrders();

    @Query(value = "select sum(o.price) from orders o",
            nativeQuery=true
    )
    Integer getSumOfOrders();

    @Query(value = "select count(*) from orders",
            nativeQuery=true
    )
    Integer getOrdersCount();
}
