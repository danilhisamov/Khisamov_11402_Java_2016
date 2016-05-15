package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entity.CarEntity;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Repository
public interface CarRepository  extends JpaRepository<CarEntity,Long>{
    CarEntity findOneById(Integer id);
    List<CarEntity> findAllByStatus(String status);

    @Query(value = "select count(*) from cars",
            nativeQuery=true
    )
    Integer getAllCarsCount();

    @Query(value = "select count(*) from cars c where c.status='active'",
            nativeQuery=true
    )
    Integer getActiveCarsCount();
}
