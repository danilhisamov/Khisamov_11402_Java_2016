package sample.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.entity.OrderEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class OrdersController extends AbstractController{
    public Button orders_all;
    public Button orders_past;
    public Button orders_current;
    public Button orders_future;
    public Button menu_cars_button;
    public Button menu_orders_button;
    public TableView<OrderEntity> orders_table;
    public TableColumn<OrderEntity,String> id_column;
    public TableColumn<OrderEntity,String> carmodel_column;
    public TableColumn<OrderEntity,String> clents_column;
    public TableColumn<OrderEntity,String> pickUpDate_column;
    public TableColumn<OrderEntity,String> dropOffDate_column;
    public TableColumn<OrderEntity,String> price_column;

    @FXML
    private void initialize(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        id_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        carmodel_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCar().getModel()));

        clents_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getClient().getUser().getFirstname()) + "  " + String.valueOf(cellData.getValue().getClient().getUser().getSurname())));

        pickUpDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getPickUpDate())));

        dropOffDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getDropOffDate())));

        price_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));


        ObservableList<OrderEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getOrders());

        orders_table.setItems(list);
    }

    public void moveToCars(ActionEvent actionEvent) {
        app.changeScene("cars-scene");
    }

    public void moveToOrders(ActionEvent actionEvent) {
        app.changeScene("orders-scene");
    }

    public void showAll(ActionEvent actionEvent) {
        app.changeScene("orders-scene");
    }

    public void showPast(ActionEvent actionEvent) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        id_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        carmodel_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCar().getModel()));

        clents_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getClient().getUser().getFirstname()) + "  " + String.valueOf(cellData.getValue().getClient().getUser().getSurname())));

        pickUpDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getPickUpDate())));

        dropOffDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getDropOffDate())));

        price_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));


        ObservableList<OrderEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getPastOrders());

        orders_table.setItems(list);
    }

    public void showCurrent(ActionEvent actionEvent) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        id_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        carmodel_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCar().getModel()));

        clents_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getClient().getUser().getFirstname()) + "  " + String.valueOf(cellData.getValue().getClient().getUser().getSurname())));

        pickUpDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getPickUpDate())));

        dropOffDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getDropOffDate())));

        price_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));


        ObservableList<OrderEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getCurrentOrders());

        orders_table.setItems(list);
    }

    public void showFuture(ActionEvent actionEvent) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        id_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        carmodel_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCar().getModel()));

        clents_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getClient().getUser().getFirstname()) + "  " + String.valueOf(cellData.getValue().getClient().getUser().getSurname())));

        pickUpDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getPickUpDate())));

        dropOffDate_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(format.format(cellData.getValue().getDropOffDate())));

        price_column.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));


        ObservableList<OrderEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getFutureOrders());

        orders_table.setItems(list);
    }

}
