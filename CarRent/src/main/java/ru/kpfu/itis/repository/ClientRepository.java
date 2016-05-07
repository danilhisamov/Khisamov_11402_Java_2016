package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entity.ClientEntity;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long>{
    List<ClientEntity> findAll();
    ClientEntity findOneById(Integer id);
}
