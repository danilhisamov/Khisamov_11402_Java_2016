package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entity.OrderEntity;
import ru.kpfu.itis.repository.OrderRepository;
import ru.kpfu.itis.service.OrderService;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void saveNewOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderEntity> getRidesByUserId(Integer id) {
        List<OrderEntity> list = orderRepository.findAllByClient_id(id);
        return list;
    }
}
