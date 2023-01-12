package clients;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

public class Photos extends Application{
    private int currentAd = 0;
    private Image[] ads = {

        new Image("images/pic0001.jpg"),
        new Image("images/pic0002.jpg"),
        new Image("images/pic0003.jpg"),
        new Image("images/pic0004.jpg"),
        new Image("images/pic0005.jpg"),
        new Image("images/pic0006.jpg"),
        new Image("images/pic0007.jpg")
    };


    public void start(Stage primaryStage) {
        ImageView imageView = new ImageView(ads[currentAd]);

        StackPane root = new StackPane();
        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 300, 400);

        primaryStage.setTitle("Ad Display Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(5), e -> {
                currentAd = (currentAd + 1) % ads.length;
                imageView.setImage(ads[currentAd]);
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}