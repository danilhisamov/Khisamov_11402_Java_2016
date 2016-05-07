package ru.kpfu.itis.service;

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
}
