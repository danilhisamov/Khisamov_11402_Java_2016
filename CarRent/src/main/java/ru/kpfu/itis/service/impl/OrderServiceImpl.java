package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entity.CarEntity;
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
    @Qualifier("orderRepository")
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

    @Override
    public List<OrderEntity> getAllByCarId(Integer id) {
        return orderRepository.findAllByCar_id(id);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderEntity> getAllPastOrders() {
        return orderRepository.findAllPastOrders();
    }

    @Override
    public List<OrderEntity> getAllCurrentOrders() {
        return orderRepository.findAllCurrentOrders();
    }

    @Override
    public List<OrderEntity> getAllFutureOrders() {
        return orderRepository.findAllFutureOrders();
    }

    @Override
    public Integer getSumOfOrders() {
        return orderRepository.getSumOfOrders();
    }

    @Override
    public Integer getOrdersCount() {
        return orderRepository.getOrdersCount();
    }

}
