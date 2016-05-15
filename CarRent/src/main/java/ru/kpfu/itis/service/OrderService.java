package ru.kpfu.itis.service;

import org.aspectj.weaver.ast.Or;
import ru.kpfu.itis.entity.CarEntity;
import ru.kpfu.itis.entity.OrderEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public interface OrderService {
    void saveNewOrder(OrderEntity orderEntity);
    List<OrderEntity> getRidesByUserId(Integer id);
    List<OrderEntity> getAllByCarId(Integer id);
    List<OrderEntity> getAllOrders();
    List<OrderEntity> getAllPastOrders();
    List<OrderEntity> getAllCurrentOrders();
    List<OrderEntity> getAllFutureOrders();
    Integer getSumOfOrders();
    Integer getOrdersCount();
}
