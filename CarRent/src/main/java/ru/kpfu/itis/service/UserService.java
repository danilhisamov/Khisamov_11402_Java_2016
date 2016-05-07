package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.form.RegistrationForm;

/**
 * @author Danil Khisamov
 *         11-402
 */
public interface UserService {
    void saveNewUser (RegistrationForm form);
    UserEntity getUserByLogin(String login);
}
