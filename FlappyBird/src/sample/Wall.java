package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * @author Danil Khisamov
 *         11-402
 */
public class Wall extends Pane {
    Rectangle rect;
    public int height;
    public Wall(int height){
        this.height = height;

        rect = new Rectangle(30,height, Color.GREEN);
        getChildren().add(rect);
    }
}
