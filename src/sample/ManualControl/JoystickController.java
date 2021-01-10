package sample.ManualControl;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import sample.StaticClasses.Point;

public class JoystickController{

    @FXML
    private Circle circleArea;

    @FXML
    private Circle joystickCircle;

    public double aileronRatio;

    public double elevatorRatio;

    @FXML
    private void onJoystickMoved(MouseEvent event) {
        final Point circleCenter = new Point(circleArea.getCenterX(), circleArea.getCenterY());
        final double circleRadius = circleArea.getRadius();
        final Point joystickPoint = new Point(event.getX(), event.getY());
        if (Point.distance(circleCenter, joystickPoint) <= circleRadius) {
            joystickCircle.setCenterX(joystickPoint.x);
            joystickCircle.setCenterY(joystickPoint.y);
            this.aileronRatio = (joystickPoint.x - circleCenter.x) / circleRadius;
            this.elevatorRatio = (joystickPoint.y - circleCenter.y) / circleRadius;
        }
    }

    @FXML
    private void onJoystickReleased(MouseEvent event) {
        final Point circleCenter = new Point(circleArea.getCenterX(), circleArea.getCenterY());
        joystickCircle.setCenterX(circleCenter.x);
        joystickCircle.setCenterY(circleCenter.y);
    }

}
