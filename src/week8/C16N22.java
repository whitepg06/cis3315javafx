package week8;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Play some audio.
 *
 * @author Administrator
 */
public class C16N22 extends Application {

    AudioClip audioClip = new AudioClip(
            "http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3");
//    MediaPlayer mp = new MediaPlayer(new Media("http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3"));

    
    @Override
    public void start(Stage primaryStage) {
        Button btPlay = new Button("Play");
        Button btLoop = new Button("Loop");
        Button btStop = new Button("Stop");

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPlay, btLoop, btStop);
        
        btPlay.setOnAction(e -> {
            audioClip.setCycleCount(1);
            audioClip.play();
        });
        
        btLoop.setOnAction(e -> {
            audioClip.setCycleCount(Timeline.INDEFINITE);
            audioClip.play();
        });
        
        btStop.setOnAction(e -> audioClip.stop());

        Scene scene = new Scene(hBox, 200, 100);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
