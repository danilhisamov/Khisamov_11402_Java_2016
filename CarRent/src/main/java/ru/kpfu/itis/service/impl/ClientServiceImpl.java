package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entity.ClientEntity;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.form.RegistrationForm;
import ru.kpfu.itis.repository.ClientRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.ClientService;
import ru.kpfu.itis.util.ClientRegistrFormTrans;

import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Qualifier("clientRepository")
    @Autowired
    ClientRepository clientRepository;

    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;



    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public void saveNewClient(RegistrationForm registrationForm) {
        UserEntity userEntity = ClientRegistrFormTrans.transform(registrationForm);
        ClientEntity clientEntity = new ClientEntity();

        userEntity.setClient(clientEntity);

        clientEntity.setId(userEntity.getId());
        clientEntity.setRides_count(0);
        clientEntity.setDiscount(0);
        clientEntity.setUser(userEntity);
        System.out.println(clientEntity);

        userRepository.save(userEntity);
        clientRepository.save(clientEntity);
    }


}
