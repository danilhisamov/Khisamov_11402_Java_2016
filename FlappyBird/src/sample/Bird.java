package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Bird extends Pane {
    Rectangle rect;
    ImageView img = new ImageView("img/bird.png");
    public Point2D velocity;

    public Bird(){
        rect = new Rectangle(50,37);
        velocity = new Point2D(0,0);
        setTranslateX(300);
        setTranslateY(100);
        getChildren().add(img);
    }

    public void moveY(int value){
        boolean moveDown = value < 0;
        ArrayList<Wall> walls = new ArrayList<>();
        walls.add(Main.down);
        walls.add(Main.up);
        for (int i = 0; i < Math.abs(value);i++){
            for (Wall w : walls){
                if (this.getBoundsInParent().intersects(w.getBoundsInParent())){
                    if (moveDown){
                        setTranslateY(getTranslateY() + 1);
                        return;
                    }else{
                        setTranslateY(getTranslateY() - 1);
                        return;
                    }
                }
            }

            if (getTranslateY() < 0){
                setTranslateY(0);
            }
            if (getTranslateY() > 567){
                setTranslateY(567);
            }
            this.setTranslateY(getTranslateY() + (moveDown?-1:1));
        }
    }

    public void moveX(int value){
        ArrayList<Wall> walls = new ArrayList<>();
        walls.add(Main.down);
        walls.add(Main.up);
        for (int i = 0; i < value;i++){
            for (Wall w : walls){
                if (getBoundsInParent().intersects(w.getBoundsInParent())){
                    if (getTranslateX() + 50 == w.getTranslateX()){
                        setTranslateX(getTranslateX() - 1);
                        return;
                    }
                }
                if (getTranslateX() == w.getTranslateX()){
                    Main.score++;
                }
            }
            setTranslateX(getTranslateX() + 1);
        }
    }

    public void jump(){
        velocity = new Point2D(3,-15);
    }
}
