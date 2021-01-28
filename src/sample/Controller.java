/**class Controller
 * @author Matteo Falkenberg
 * @version 1.8, 28.01.2021
 */

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ColorCode;
import model.Model;

public class Controller {

    @FXML
    TextField redField;
    @FXML
    TextField greenField;
    @FXML
    TextField blueField;
    @FXML
    Button colorBtn;
    @FXML
    Label hexLbl;

    private Model model = new Model();


    @FXML
    public void initialize() {
        changeBtnColor();
    }


    private void changeBtnColor(){
        int r = model.getRed();
        int g = model.getGreen();
        int b = model.getBlue();

        colorBtn.setStyle("-fx-background-color: rgb(" + r + ", " + g + ", " + b + ");");
        hexLbl.setText("Hex: " + model.getHex());
    }


    @FXML
    private void saveValues(){
        model.saveToFile();
    }


    @FXML
    private void loadValues(){
        model.loadFromFile();
        redField.setText("" + model.getRed());
        greenField.setText("" + model.getGreen());
        blueField.setText("" + model.getBlue());
        changeBtnColor();
    }


    @FXML
    private void fieldInputR(){
        try {
            model.changeColorViaAbsoluteValue(ColorCode.RED, redField.getText());
            changeBtnColor();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("invalid input");
        }
    }

    @FXML
    private void fieldInputG(){
        try {
            model.changeColorViaAbsoluteValue(ColorCode.GREEN, greenField.getText());
            changeBtnColor();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("invalid input");
        }
    }

    @FXML
    private void fieldInputB(){
        try {
            model.changeColorViaAbsoluteValue(ColorCode.BLUE, blueField.getText());
            changeBtnColor();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("invalid input");
        }
    }


    @FXML
    private void valIncTenR(){
        model.changeColorViaRelativeValue(ColorCode.RED, 10);
        redField.setText(Integer.toString(model.getRed()));
        changeBtnColor();
    }

    @FXML
    private void valDecTenR(){
        model.changeColorViaRelativeValue(ColorCode.RED, -10);
        redField.setText(Integer.toString(model.getRed()));
        changeBtnColor();
    }


    @FXML
    private void valIncTenG(){
        model.changeColorViaRelativeValue(ColorCode.GREEN, 10);
        greenField.setText(Integer.toString(model.getGreen()));
        changeBtnColor();
    }

    @FXML
    private void valDecTenG(){
        model.changeColorViaRelativeValue(ColorCode.GREEN, -10);
        greenField.setText(Integer.toString(model.getGreen()));
        changeBtnColor();
    }


    @FXML
    private void valIncTenB(){
        model.changeColorViaRelativeValue(ColorCode.BLUE, 10);
        blueField.setText(Integer.toString(model.getBlue()));
        changeBtnColor();
    }

    @FXML
    private void valDecTenB(){
        model.changeColorViaRelativeValue(ColorCode.BLUE, -10);
        blueField.setText(Integer.toString(model.getBlue()));
        changeBtnColor();
    }

}
