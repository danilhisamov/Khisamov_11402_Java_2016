package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entity.CarEntity;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Repository
public interface CarRepository  extends JpaRepository<CarEntity,Long>{
    CarEntity findOneById(Integer id);
}
