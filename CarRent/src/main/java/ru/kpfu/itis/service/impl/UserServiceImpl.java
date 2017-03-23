package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.form.RegistrationForm;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.ClientRegistrFormTrans;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Service
public class UserServiceImpl implements UserService{
    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;

    @Transactional
    public void saveNewUser(RegistrationForm form) {
        UserEntity userEntity = ClientRegistrFormTrans.transform(form);
        userRepository.save(userEntity);
    }

    public UserEntity getUserByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }
}
