package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import sample.entity.CarEntity;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class AddCarController extends AbstractController{
    public TextField model;
    public TextField seats;
    public TextField luggage;
    public TextField price;
    public Button addCarButton;
    public TextField doors;
    public ChoiceBox select;
    public Button cancel;


    public void addNewCar(ActionEvent actionEvent) {
        CarEntity carsEntity = new CarEntity();
        carsEntity.setModel(model.getText());
        carsEntity.setAir_cond("yes");
        carsEntity.setPrice(Integer.parseInt(price.getText()));
        carsEntity.setDoors(Integer.parseInt(doors.getText()));
        carsEntity.setSeats(Integer.parseInt(seats.getText()));
        carsEntity.setLuggage(luggage.getText());
        carsEntity.setTransmission(select.getSelectionModel().getSelectedItem().toString());
        carsEntity.setStatus("active");
        server.postNewCar(carsEntity);

        app.changeScene("cars-scene");
    }

    public void backToCars(ActionEvent actionEvent) {
        app.changeScene("cars-scene");
    }
}
