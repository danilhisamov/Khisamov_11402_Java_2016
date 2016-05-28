package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Bonus extends Pane {
    Rectangle rect;

    public Bonus(){
        rect = new Rectangle(20,20, Color.RED);
        getChildren().add(rect);
    }
}
