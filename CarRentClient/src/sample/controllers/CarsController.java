package sample.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.entity.CarEntity;
import sample.entity.OrderEntity;

import java.text.SimpleDateFormat;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class CarsController extends AbstractController {

    public Button menu_cars_button;
    public Button menu_orders_button;
    public TableView<CarEntity> carsTable;
    public TableColumn<CarEntity,String> carsIdColumn;
    public TableColumn<CarEntity,String> carsModelColumn;
    public TableColumn<CarEntity,String> carsSeatsColumn;
    public TableColumn<CarEntity,String> carsLuggageColumn;
    public TableColumn<CarEntity,String> carsPriceColumn;
    public TableColumn<CarEntity,String> carsTransmissionColumn;
    public Button addCarButton;
    public TableColumn<CarEntity,String> carStatus;

    @FXML
    private void initialize(){

        carsIdColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        carsModelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getModel()));

        carsSeatsColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getSeats())));
        carsLuggageColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getLuggage())));

        carsTransmissionColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getTransmission())));

        carsPriceColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));

        carStatus.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getStatus())));



        ObservableList<CarEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getCars());

        carsTable.setItems(list);
    }

    public void addNewCar(ActionEvent actionEvent) {
        app.changeScene("save-new-car");
    }

    public void moveToCars(ActionEvent actionEvent) {
        app.changeScene("cars-scene");
    }

    public void moveToOrders(ActionEvent actionEvent) {
        app.changeScene("orders-scene");
    }
}
