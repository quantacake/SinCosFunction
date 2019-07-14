package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Axes {

    Pane pane;
    double width = 600;
    double height = 300;

    public Axes() {}

    public Axes(Pane pane) {
        this.pane = pane;
    };

    public Axes(double height, double width) {
        this.height = height;
        this.width = width;
    }

    // y axis line
    public Line setYAxis() {
        Line line = new Line(0, height/2, width, height/2);
        line.setStroke(Color.WHITESMOKE);
        return line;
    }

    // x axis line
    public Line setXAxis() {
        Line line = new Line(width/2, 0, width/2, height);
        line.setStroke(Color.WHITESMOKE);
        return line;
    }

    // set x units
    public StackPane setXUnits() {

        StackPane stackPane = new StackPane();
        HBox hBox = new HBox();

        Text text1 = new Text("-2\u03c0");
        Text text2 = new Text("-\u03c0");
        Text text3 = new Text("0");
        Text text4 = new Text("\u03c0");
        Text text5 = new Text("2\u03c0");

        text1.setStroke(Color.GREEN);
        text2.setStroke(Color.GREEN);
        text3.setStroke(Color.GREEN);
        text4.setStroke(Color.GREEN);
        text5.setStroke(Color.GREEN);

        // size and center stackpane
        stackPane.setMinHeight(height + 20);
        stackPane.setMinWidth(width - 25);
        stackPane.setAlignment(Pos.CENTER);

        // center align hbox
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(width/5);

        hBox.getChildren().addAll(text1, text2, text3, text4, text5);
        stackPane.getChildren().add(hBox);

        return stackPane;
    }

    // set y units
    public StackPane setYUnits() {

        StackPane stackPane = new StackPane();
        VBox vBox = new VBox();

        Text text1 = new Text("2");
        Text text2 = new Text("1");
        Text text3 = new Text("");
        Text text4 = new Text("-1");
        Text text5 = new Text("-2");

        text1.setStroke(Color.GREEN);
        text2.setStroke(Color.GREEN);
        text3.setStroke(Color.GREEN);
        text4.setStroke(Color.GREEN);
        text5.setStroke(Color.GREEN);

        stackPane.setMinHeight(height);
        stackPane.setMinWidth(width -20);
        stackPane.setAlignment(Pos.CENTER);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(height/6);

        vBox.getChildren().addAll(text1, text2, text3, text4, text5);
        stackPane.getChildren().add(vBox);

        return stackPane;
    }

}
