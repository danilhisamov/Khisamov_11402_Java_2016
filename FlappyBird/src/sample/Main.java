package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main extends Application {
    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();
    Bird bird = new Bird();

    public static ArrayList<Wall> upWalls = new ArrayList<>();
    public static ArrayList<Wall> downWalls = new ArrayList<>();

    public static Wall up;
    public static Wall down;

    static int upWallIt = 0;
    static int downWallIt = 0;


    public static int score = 0;
    public Label scoreLabel = new Label("Score : " + score);

    public Parent createContent(){
        gameRoot.setPrefSize(600,600);

        for (int i = 0; i < 100;i++){
            ImageView imageView = new ImageView("img/bg1.png");
            imageView.setFitWidth(600);
            imageView.setFitHeight(600);
            imageView.setTranslateX(i * 600);
            imageView.setTranslateY(0);
            gameRoot.getChildren().addAll(imageView);
            Random random = new Random();
            int space = random.nextInt(150) + 100;
            int height = random.nextInt(600 - space);

            Wall wall = new Wall(height + 100);
            wall.setTranslateX(i * 350 + 600);
            wall.setTranslateY(-100);
            upWalls.add(wall);

            Wall wall2 = new Wall(600 - space - height + 100);
            wall2.setTranslateX(i*350 + 600);
            wall2.setTranslateY(height + space + 100);
            downWalls.add(wall2);

        }

        up = upWalls.get(upWallIt);
        down = downWalls.get(downWallIt);

        gameRoot.getChildren().addAll(bird);
        gameRoot.getChildren().addAll(downWalls);
        gameRoot.getChildren().addAll(upWalls);
        appRoot.getChildren().addAll(gameRoot);
        appRoot.getChildren().addAll(scoreLabel);
        return appRoot;
    }

    public void refresh(){
        if (bird.velocity.getY()<5){
            bird.velocity = bird.velocity.add(0,1);
        }

        bird.moveX((int) bird.velocity.getX());
        bird.moveY((int) bird.velocity.getY());

        scoreLabel.setText("Score: " + score);

        bird.translateXProperty().addListener((obs,old,newValue)->{
            int offset = newValue.intValue();
            if (offset > 200){
                gameRoot.setLayoutX(-(offset - 200));
            }
        });

        if (bird.getTranslateX() >= up.getTranslateX()){
            upWallIt++;
            downWallIt++;
            up = upWalls.get(upWallIt);
            down = downWalls.get(downWallIt);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());

        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(3000), bird);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        scene.setOnKeyTyped(event -> bird.jump());

        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        for (Wall wall : upWalls) {
            final KeyValue kv = new KeyValue(wall.rect.yProperty(), 100);
            final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
            timeline.getKeyFrames().add(kf);
        }
        for (Wall wall : downWalls) {
            final KeyValue kv = new KeyValue(wall.rect.yProperty(), -100);
            final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
            timeline.getKeyFrames().add(kf);
        }
        timeline.play();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                refresh();
            }
        };
        timer.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
