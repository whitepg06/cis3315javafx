package week6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author John
 */
public class Cards1 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane hbox = new HBox(5);
        ScrollPane sp = new ScrollPane(hbox);
        hbox.setPadding(new Insets(50, 50, 50, 50));

        ImageView[] iv = new ImageView[53];
        for (int i = 0; i < 53; i++) {
            iv[i] = new ImageView(new Image("image/card/" + (i + 1) + ".png"));
        }

        hbox.getChildren().addAll(iv);
        
        iv[1].setImage(new Image("image/card/" + (53) + ".png")); 

        Scene scene = new Scene(sp, 600, 250);

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
