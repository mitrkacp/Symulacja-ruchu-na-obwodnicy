
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class Controller implements Initializable {
    Simulation sim = new Simulation();

    @FXML
    public void buttonClicked() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Part1NewWindow.fxml"));
        ScrollPane scrollPane = new ScrollPane();
        GridPane root = new GridPane();
        Stage stage = new Stage();
        stage.setTitle("Part 1");
        scrollPane.setContent(root);
        root.setVgap(10);
        stage.setScene(new Scene(scrollPane, 550, 450));

        for (int i = 0; i < sim.roads.get(0).getLength(); ++i) {
            for (int j = 0; j < sim.roads.get(0).getWidth(); ++j) {
                Rectangle r = new Rectangle();
                r.setHeight(20);
                r.setWidth(20);
                r.setFill(Color.LIGHTGRAY);
                root.add(r, i, j, 1, 1);
            }
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        for (int lane = 0; lane < sim.roads.get(0).getWidth(); lane++) {
                            for(int position = 0; position < sim.roads.get(0).getLength(); position++){
                                if (sim.roads.get(0).getRoadArray(lane,position) != null) {
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane, position, root);
                                    car.setFill(Color.BLUE);
                                }
                                else{
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane, position, root);
                                    car.setFill(Color.LIGHTGREY);
                                }
                            }
                        }
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();



        stage.show();

    }


    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sim.start();
    }
}
