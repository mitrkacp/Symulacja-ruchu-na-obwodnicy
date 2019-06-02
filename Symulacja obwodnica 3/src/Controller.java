
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    Simulation sim = new Simulation();


    public void part(int id) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Part1NewWindow.fxml"));
        ScrollPane scrollPane = new ScrollPane();
        GridPane root = new GridPane();
        Stage stage = new Stage();
        if(id==1)stage.setTitle(sim.getIntersections().get(15).getDesc() + " - " + sim.getIntersections().get(id-1).getDesc() );
        else stage.setTitle(sim.getIntersections().get(id - 2).getDesc() + " - " + sim.getIntersections().get(id-1).getDesc() );
        scrollPane.setContent(root);
        root.setVgap(5);
        //stage.getIcons().add(new Image("file:icon.png"));
        stage.setScene(new Scene(scrollPane, 1000, 200));

        for (int i = 0; i < sim.roads.get((id-1)*2).getLength(); ++i) {
            for (int j = 0; j < sim.roads.get((id-1)*2).getWidth()*2+1; ++j) {
                Rectangle r = new Rectangle();
                r.setHeight(10);
                r.setWidth(10);
                r.setFill(Color.LIGHTGRAY);
                if(j==3) r.setFill(Color.DARKGREEN);
                root.add(r, i, j, 1, 1);
            }
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        for (int lane = 0; lane < sim.roads.get((id-1)*2).getWidth(); lane++) {
                            for(int position = 0; position < sim.roads.get((id-1)*2).getLength(); position++){
                                if (sim.roads.get((id-1)*2).getRoadArray(lane,position) != null) {
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane+4, position, root);
                                    car.setFill(Color.BLUE);
                                }
                                else{
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane+4, position, root);
                                    car.setFill(Color.LIGHTGRAY);
                                }
                            }
                        }

                        for (int lane = 0; lane < sim.roads.get((id-1)*2+1).getWidth(); lane++) {
                            for(int position = 0; position < sim.roads.get((id-1)*2+1).getLength(); position++){
                                if (sim.roads.get((id-1)*2+1).getRoadArray(lane,position) != null) {
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane , sim.roads.get((id-1)*2+1).getLength()-1- position, root);
                                    car.setFill(Color.PURPLE);
                                }
                                else{
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane,  sim.roads.get((id-1)*2+1).getLength()-1-position, root);
                                    car.setFill(Color.LIGHTGRAY);
                                }
                            }
                        }
                    }
                    };

                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                           return ;
                    }
                    finally {

                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown
        //thread.setDaemon(true);
        thread.start();



        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                try {
                    thread.interrupt();
                }
                catch(Exception e){

                }
                }
        });
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

    public void PrintPart(ActionEvent event){
        Node node = (Node) event.getSource();
        int partNumber = Integer.parseInt((String) node.getUserData());

        try {
            part(partNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sim.start();
    }
}
