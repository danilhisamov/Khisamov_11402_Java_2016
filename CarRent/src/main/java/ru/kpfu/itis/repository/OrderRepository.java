package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.entity.OrderEntity;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findAllByClient_id(Integer id);
}
