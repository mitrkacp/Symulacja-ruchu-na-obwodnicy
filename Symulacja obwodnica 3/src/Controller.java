
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
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
        stage.setTitle("Part 1");
        scrollPane.setContent(root);
        root.setVgap(5);
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
            private boolean flaga = true;
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("AUUUUUUUUUUUUUUUUUUUUUUUUUUU");
                        for (int lane = 0; lane < sim.roads.get((id-1)*2).getWidth(); lane++) {
                            for(int position = 0; position < sim.roads.get((id-1)*2).getLength(); position++){
                                if (sim.roads.get((id-1)*2).getRoadArray(lane,position) != null) {
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane+4, position, root);
                                    car.setFill(Color.BLUE);
                                }
                                else{
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane+4, position, root);
                                    car.setFill(Color.LIGHTGREY);
                                }
                            }
                        }

                        for (int lane = 0; lane < sim.roads.get((id-1)*2+1).getWidth(); lane++) {
                            for(int position = 0; position < sim.roads.get((id-1)*2+1).getLength(); position++){
                                if (sim.roads.get((id-1)*2+1).getRoadArray(lane,position) != null) {
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane , sim.roads.get((id-1)*2+1).getLength()-1- position, root);
                                    car.setFill(Color.BLUE);
                                }
                                else{
                                    Rectangle car = (Rectangle) getNodeByRowColumnIndex(lane,  sim.roads.get((id-1)*2+1).getLength()-1-position, root);
                                    car.setFill(Color.LIGHTGREY);
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

            public void close(){
                this.flaga = false;
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

    public void PrintPart1(){
        try {
            part(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PrintPart2(){
        try {
            part(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart3(){
        try {
            part(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart4(){
        try {
            part(4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart5(){
        try {
            part(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart6(){
        try {
            part(6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart7(){
        try {
            part(7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart8(){
        try {
            part(8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart9(){
        try {
            part(9);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart10(){
        try {
            part(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart11(){
        try {
            part(11);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart12(){
        try {
            part(12);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart13(){
        try {
            part(13);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart14(){
        try {
            part(14);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart15(){
        try {
            part(15);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void PrintPart16(){
        try {
            part(16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sim.start();
    }
}
