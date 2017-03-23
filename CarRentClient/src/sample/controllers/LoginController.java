package sample.controllers;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.server.ServerAuth;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class LoginController extends AbstractController{


    public Button login_button;
    public TextField login_textfield;
    public Label login_label;
    public Label password_label;
    public PasswordField password_textfield;
    public Label error_label;

    public void login(Event event) {
        ServerAuth auth = new ServerAuth();
        if (auth.tryAuth(login_textfield.getText(), password_textfield.getText())) {
            switch (ServerAuth.role){
                case ROLE_ADMIN:
                    app.changeScene("orders-scene");
                    break;
//                case ROLE_CUSTOMER:
//                    app.changeScene("customer/NewApplicationPage");
//                    break;
//
//                case ROLE_DRIVER:
//                    app.changeScene("driver/ApplicationsPage");
//                    break;
                default:app.changeScene("login-scene");
            }
        } else {
            error_label.setText(" Incorrect login or password");
        }
    }
}
