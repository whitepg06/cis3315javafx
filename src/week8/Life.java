package week8;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Program to run Conway's Game of Life simulation. This is just a rough draft
 * to gain insight.
 *
 * @author John Phillips
 */
public class Life extends Application {

    int xCellCount = 100;
    int yCellCount = 50;
    int CELLWIDTH = 10;
    int CELLHEIGHT = 10;
    int CELLFILLWIDTH = 9;
    int CELLFILLHEIGHT = 9;

    int[][] cells = new int[xCellCount][yCellCount];
    Pane pane = new Pane();
    BorderPane borderPane = new BorderPane();
    private Timeline animation;
    int iteration = 0;
    Button btPause, btSlower, btFaster, btInit;

    @Override
    public void start(Stage primaryStage) {
        initCells();
        borderPane.setCenter(pane);

        Button btInit = new Button("Initialize");
        btInit.setOnAction(e -> {
            initCells();
            drawCells();
        });

        btPause = new Button("Pause");
        btPause.setOnAction(e -> {
            if (btPause.getText().equals("Pause")) {
                btPause.setText("Play");
                pause();
            } else {
                btPause.setText("Pause");
                play();
            }
        });

        btSlower = new Button("Slower");
        btSlower.setOnAction(e -> {
            decreaseSpeed();
        });

        btFaster = new Button("Faster");
        btFaster.setOnAction(e -> {
            increaseSpeed();
        });

        HBox btBox = new HBox(15);
        btBox.setAlignment(Pos.CENTER);
        btBox.setPadding(new Insets(5, 0, 5, 0));

        btBox.getChildren().addAll(btInit, btSlower, btFaster, btPause);

        borderPane.setBottom(btBox);

        animation = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> {
                    nextGen();
                    drawCells();
                })
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        initCells();
        drawCells();

        Scene scene = new Scene(borderPane);

        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
        animation.play();
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.5);
    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() - 0.5);
    }

    public void initCells() {
        for (int y = 0; y < yCellCount; y++) {
            for (int x = 0; x < xCellCount; x++) {
                cells[x][y] = Math.random() > 0.5 ? 0 : 1;
            }
        }
    }

    public void drawCells() {
        pane.getChildren().clear();
        for (int y = 0; y < yCellCount; y++) {
            for (int x = 0; x < xCellCount; x++) {
                Rectangle rect = new Rectangle(x * CELLWIDTH, y * CELLHEIGHT,
                        CELLFILLWIDTH, CELLFILLHEIGHT);
                rect.setFill(cells[x][y] == 0 ? Color.WHITE : Color.BLACK);
                pane.getChildren().add(rect);
            }
        }
    }

    // decide who lives and dies in the next generation
    public void nextGen() {
        int[][] cellsng = new int[xCellCount][yCellCount];

        // count how many living neighbors each cell has
        for (int y = 0; y < yCellCount; y++) {
            for (int x = 0; x < xCellCount; x++) {

                int neighbors = 0;
                if (x > 1 && x < xCellCount - 1 && y > 1 && y < yCellCount - 1) {

                    // check row above cell x,y
                    if (cells[x - 1][y - 1] == 1) {
                        neighbors++;
                    }
                    if (cells[x][y - 1] == 1) {
                        neighbors++;
                    }
                    if (cells[x + 1][y - 1] == 1) {
                        neighbors++;
                    }

                    // check neighbors left and right of cell x,y
                    if (cells[x - 1][y] == 1) {
                        neighbors++;
                    }
//                    if (cells[x][y] == 1) {
//                        neighbors++;
//                    }
                    if (cells[x + 1][y] == 1) {
                        neighbors++;
                    }

                    // check neighbors below cell x,y
                    if (cells[x - 1][y + 1] == 1) {
                        neighbors++;
                    }
                    if (cells[x][y + 1] == 1) {
                        neighbors++;
                    }
                    if (cells[x + 1][y + 1] == 1) {
                        neighbors++;
                    }

                    // decide who lives or dies
                    if (cells[x][y] == 1) {

                        // check for loneliness or overcrowding
                        if (neighbors < 2 || neighbors > 3) {
                            cellsng[x][y] = 0;
                        } else {
                            cellsng[x][y] = 1;
                        }

                        // check if dead cell should come alive
                    } else if (neighbors == 3) {
                        cellsng[x][y] = 1;
                    }

                    // kill edge cells
                } else {
                    cellsng[x][y] = 0;
                }
            }
        }

        // update the current generation to be the next generation
        cells = cellsng;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
