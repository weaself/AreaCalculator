package AreaCalculator;

import com.sun.xml.internal.ws.api.FeatureConstructor;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;

public class FXMainController {
    DecimalFormat twoPlacesFormat = new DecimalFormat("##.00");

    @FXML
    private Button rectangleResultButton;
    @FXML
    private Button triangleResultButton;
    @FXML
    private TextField rectangleSideATextField;
    @FXML
    private TextField rectangleSideBTextField;
    @FXML
    private TextField rectangleResultTextField;
    @FXML
    private TextField triangleSideATextfield;
    @FXML
    private TextField triangleSideBTextfield;
    @FXML
    private TextField triangleSideCTextfield;
    @FXML
    private TextField triangleResultTextfield;

    public FXMainController() {
    }

    private void setRectangleAreaInResultTextfield() {
        Rectangle rect;
        double result;
        try {
            double sideA = Double.parseDouble(rectangleSideATextField.getText());
            double sideB = Double.parseDouble(rectangleSideBTextField.getText());
            rect = new Rectangle(sideA, sideB);
            rect.calculateRectangleArea();
            result = rect.getArea();
            rectangleResultTextField.setText(String.valueOf(result));

            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Either of the arguments is wrong!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setTriangleResultField() {
        Triangle triangle;
        double result;

        double sideA = Double.parseDouble(triangleSideATextfield.getText());
        double sideB = Double.parseDouble(triangleSideBTextfield.getText());
        double sideC = Double.parseDouble(triangleSideCTextfield.getText());
        try {
            triangle = new Triangle(sideA, sideB, sideC);
            triangle.calculateTriangleArea();
            result = triangle.getArea();
            triangleResultTextfield.setText(twoPlacesFormat.format(String.valueOf(result)));
        } catch (Exception ex) {
            System.out.println("Bad arguments.");
        }

    }

    @FXML
    void keyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) setRectangleAreaInResultTextfield();
    }

    @FXML
    void triangleResultButtonKeyPressed(MouseEvent event) {
        setTriangleResultField();
    }

    @FXML
    void initialize() {
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*System.out.println("My handler???");
                System.out.println(sideATextField.getText());*/
                setRectangleAreaInResultTextfield();
            }
        };



        rectangleResultButton.addEventHandler(ActionEvent.ACTION, handler);
    }
}
