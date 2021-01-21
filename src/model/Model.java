/**class Model
 * @author Matteo Falkenberg
 * @version 1.0, 21.01.2021
 */

package model;

public class Model {

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;

    Model(){

    }


    public void changeColorViaAbsoluteValue(ColorCode cc, String value){

    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value){

    }


    public void changeColorViaRelativeValue(ColorCode cc, String value){

    }

    public void changeColorViaRelativeValue(ColorCode cc, int value){

    }


    public int getRed() {
        return red.getValue();
    }

    public int getGreen() {
        return green.getValue();
    }

    public int getBlue() {
        return blue.getValue();
    }


    public String getHex(){
        int r = getRed();
        int g = getGreen();
        int b = getBlue();

        String hex = String.format("#%02x%02x%02x", r, g, b);
        return hex;
    }


    public String toString(){
        String s = "Model: " + this;
        return s;
    }


    public static void main(String[] args){

    }

}
