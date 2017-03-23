package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entity.UserEntity;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    UserEntity findOneByLogin(String login);
}
