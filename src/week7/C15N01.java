package week7;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class C15N01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= 52; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);

        HBox hBox = new HBox(-25);
        hBox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 5; i++) {
            hBox.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
        }

        Button btRefresh = new Button("Refresh");
        btRefresh.setOnAction(e -> {
            java.util.Collections.shuffle(list);
            hBox.getChildren().clear();
            for (int i = 0; i < 5; i++) {
                hBox.getChildren().add(new ImageView("image/card/" + list.get(i) + ".png"));
            }
        });
        
        HBox hBoxBtn = new HBox(5);
        hBoxBtn.getChildren().add(btRefresh);
        hBoxBtn.setAlignment(Pos.CENTER);
        hBoxBtn.setPadding(new Insets(5,5,20,5));
        
        BorderPane pane = new BorderPane();
        pane.setCenter(hBox);
        pane.setBottom(hBoxBtn);
        BorderPane.setAlignment(btRefresh, Pos.CENTER);

        Scene scene = new Scene(pane, 500, 250);

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
