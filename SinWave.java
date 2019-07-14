package sample;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class SinWave {

    double yAxis;
    double xAxis;
    double width = 600;
    double height = 300;

    public SinWave() {}

    public SinWave(double yAxis, double xAxis) {
        this.yAxis = yAxis;
        this.xAxis = xAxis;
    }

    public SinWave(double width, double height, double yAxis, double xAxis) {
        this.width = width;
        this.height = height;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }


    public Polyline setPoints() {

        Polyline polyline = new Polyline();

        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 50;

        // scale down polyline size
        polyline.setScaleX(xAxis*0.01);
        polyline.setScaleY(yAxis*0.01);

        // add points to list
        for(int x = -(int)width; x <= (int)width; x++) {

            list.add(x + width / 2);
            list.add(height / 2 - scaleFactor * Math.sin((x / (xAxis / Math.PI)) * 2 * Math.PI));

        }

        // set polyline color
        polyline.setStroke(Color.RED);

        return polyline;
    }

}
