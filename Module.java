package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Module extends Application {

    double height = 300;
    double width = 600;
    final double centerX = width/2;
    final double centerY = height/2;

    Axes axes;
    Pane pane = new Pane();
    SinWave sinWave;
    CosWave cosWave;


    public void changeGraph(Scene scene) {

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                // adapts to screen size
                width = scene.getWidth();
                height = scene.getHeight();

                // x and y coordinate of mouse
                double xCoord = mouseEvent.getSceneX();
                double yCoord = mouseEvent.getSceneY();

                // measures mouse location from the center.
                // default phase shift for sin and cos
                double nowX = centerX + (centerX - xCoord);
                double nowY = centerY + (centerY - yCoord);

                // make sine and cosine functions
                sinWave = new SinWave(width, height, nowY, nowX);
                cosWave = new CosWave(width, height, nowY, nowX);

                // make x and y axes
                Axes yAxis = new Axes(height, width);
                Axes xAxis = new Axes(height, width);

                // clear screen after each mouse movement
                pane.getChildren().clear();

                pane.getChildren().addAll(xAxis.setXUnits(), yAxis.setYUnits(), yAxis.setXAxis(), xAxis.setYAxis(), sinWave.setPoints(), cosWave.setPoints());
            }
        });
    }


    @Override
    public void start(Stage primaryStage) {

        pane = new Pane();
        axes = new Axes(height, width);
        sinWave = new SinWave();
        cosWave = new CosWave();

        pane.setStyle("-fx-background-color: #" + "282C34");
        pane.getChildren().addAll(axes.setXAxis(), axes.setYAxis(), sinWave.setPoints(), cosWave.setPoints());

        // create scene and show stage
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Trig Functions");
        primaryStage.setScene(scene);
        primaryStage.show();
        changeGraph(scene);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
