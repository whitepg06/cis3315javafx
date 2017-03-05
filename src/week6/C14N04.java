package week6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class C14N04 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        
        Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,48);
        
        for(int i=0; i<5; i++){
            Text txt = new Text("John");
            txt.setRotate(i * 60);
            txt.setFont(font);
            txt.setFill(new Color(Math.random(),Math.random(),1,1));
            pane.getChildren().add(txt);
        }
        
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
