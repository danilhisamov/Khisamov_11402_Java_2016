package ru.kpfu.itis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.entity.ClientEntity;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.entity.enums.Role;
import ru.kpfu.itis.form.RegistrationForm;

import javax.jws.soap.SOAPBinding;
import java.util.Objects;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class ClientRegistrFormTrans {
    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static UserEntity transform(RegistrationForm form) {
        if (form == null || (!Objects.equals(form.getPassword(), form.getRepassword()))) {
            return null;
        }
        UserEntity user = new UserEntity();
        user.setFirstname(form.getFirstname());
        user.setSurname(form.getLastname());
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
        user.setAge(form.getAge());
        user.setLogin(form.getLogin());
        user.setPassword(encoder.encode(form.getPassword()));
        user.setRole(Role.ROLE_CLIENT);
        user.setSex(form.getSex());
        return user;
    }
}
