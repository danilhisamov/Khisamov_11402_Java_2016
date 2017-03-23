package ru.kpfu.itis.service;

import ru.kpfu.itis.entity.ClientEntity;
import ru.kpfu.itis.form.RegistrationForm;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public interface ClientService {
    List<ClientEntity> getAllClients();
    void saveNewClient(RegistrationForm registrationForm);
    void save(ClientEntity clientEntity);
    Integer getAllClientCount();
}
