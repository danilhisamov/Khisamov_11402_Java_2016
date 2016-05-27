package sample.server;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.entity.CarEntity;
import sample.entity.OrderEntity;
import sample.entity.UserEntity;
import sample.entity.enums.Role;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Connection {
    private final String SERVER_URL = "http://localhost:8080/api/";

    public Role getUserRole() throws Exception {
        return mapper().readValue(getResponse("role"), Role.class);
    }

    public List<OrderEntity> getOrders() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("orders"), OrderEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public List<ContractEntity> getContracts() {
//        try {
//            return Arrays.asList(mapper().readValue(getResponse("contracts"), ContractEntity[].class));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    private ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper;
    }

    private String getResponse(String path) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
        String url = SERVER_URL + path;
        ResponseEntity resp = restTemplate.exchange(url, HttpMethod.GET, request(path), String.class);
        return resp.getBody().toString();
    }

    private void doPost(String path, Object object) {
        String url = SERVER_URL + path;
        try {
            new RestTemplate().exchange(url, HttpMethod.POST, request(object), object.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HttpEntity<String> request() throws IOException {
        return request(null);
    }

    private HttpEntity request(Object payload) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", ServerAuth.getLoginPass());
        return new HttpEntity(payload, headers);
    }


    public void updateOrderStatus(long id) {
        doPost("/orders", id);
    }

    public List<CarEntity> getAvailableCars() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("cars/available"), CarEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<CarEntity> getCars() {
        try {
            return Arrays.asList(mapper().readValue(getResponse("cars"), CarEntity[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void postNewCar(CarEntity carsEntity) {
        doPost("/cars/new", carsEntity);
    }

    public void postNewUser(UserEntity usersEntity) {
        doPost("/users/new", usersEntity);
    }
}
