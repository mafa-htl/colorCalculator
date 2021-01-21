/**class Model
 * @author Matteo Falkenberg
 * @version 1.4, 21.01.2021
 */

package model;

import java.util.Scanner;

public class Model {

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;

    Model(){

    }


    public void changeColorViaAbsoluteValue(ColorCode cc, String value){
        int valInt = Integer.parseInt(value);

        if(cc.equals(ColorCode.RED)){
            red.reset();
            red.inc(valInt);
        }

        else if(cc.equals(ColorCode.GREEN)){
            green.reset();
            green.inc(valInt);
        }

        else if(cc.equals(ColorCode.BLUE)){
            blue.reset();
            blue.inc(valInt);
        }

        else System.out.println("Ungültiger ColorCode");
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value){

        if(cc.equals(ColorCode.RED)){
            red.reset();
            red.inc(value);
        }

        else if(cc.equals(ColorCode.GREEN)){
            green.reset();
            green.inc(value);
        }

        else if(cc.equals(ColorCode.BLUE)){
            blue.reset();
            blue.inc(value);
        }

        else System.out.println("Ungültiger ColorCode");
    }


    public void changeColorViaRelativeValue(ColorCode cc, String value){
        int valInt = Integer.parseInt(value);

        if(cc.equals(ColorCode.RED)){
            if(red.getValue() + valInt > 255) {
                valInt = red.getValue() + valInt - 255;
                red.reset();
            }
            red.inc(valInt);
        }

        else if(cc.equals(ColorCode.GREEN)){
            if(green.getValue() + valInt > 255) {
                valInt = green.getValue() + valInt - 255;
                green.reset();
            }
            green.inc(valInt);
        }

        else if(cc.equals(ColorCode.BLUE)){
            if(blue.getValue() + valInt > 255) {
                valInt = blue.getValue() + valInt - 255;
                blue.reset();
            }
            blue.inc(valInt);
        }

        else System.out.println("Ungültiger ColorCode");
    }

    public void changeColorViaRelativeValue(ColorCode cc, int value){

        if(cc.equals(ColorCode.RED)){
            if(red.getValue() + value > 255) {
                value = red.getValue() + value - 255;
                red.reset();
            }
            red.inc(value);
        }

        else if(cc.equals(ColorCode.GREEN)){
            if(green.getValue() + value > 255) {
                value = green.getValue() + value - 255;
                green.reset();
            }
            green.inc(value);
        }

        else if(cc.equals(ColorCode.BLUE)){
            if(blue.getValue() + value > 255) {
                value = blue.getValue() + value - 255;
                blue.reset();
            }
            blue.inc(value);
        }

        else System.out.println("Ungültiger ColorCode");
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
        String s = "State: " + this + "\n";
        return s;
    }


    public static void main(String[] args){
        Model model = new Model();
        System.out.println(model.toString());

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nMenu");
            System.out.println("  a - changeColorViaAbsoluteValue");
            System.out.println("  r - changeColorViaRelativeValue");
            System.out.println("  ? - view all accessors");
            System.out.println("  q - quit");
            System.out.println("Enter Command");
            String input = sc.next();

            if(input.equals("a")){
                System.out.println("  Enter color (red, green, blue)");
                String colIn = sc.next();
                ColorCode colSel;

                if(colIn.toUpperCase().equals("RED")) {
                    colSel = ColorCode.RED;
                }
                else if(colIn.toUpperCase().equals("GREEN")){
                    colSel = ColorCode.GREEN;
                }
                else if(colIn.toUpperCase().equals("BLUE")){
                    colSel = ColorCode.BLUE;
                }
                else {
                    System.out.println("Ungültige Angabe\n");
                    continue;
                }

                System.out.println("  Enter value (0-255");
                String valSel = sc.next();
                model.changeColorViaAbsoluteValue(colSel, valSel);
                System.out.println(model.toString());
            }

            else if(input.equals("r")){
                System.out.println("  Enter color (red, green, blue)");
                String colIn = sc.next();
                ColorCode colSel;

                if(colIn.toUpperCase().equals("RED")) {
                    colSel = ColorCode.RED;
                }
                else if(colIn.toUpperCase().equals("GREEN")){
                    colSel = ColorCode.GREEN;
                }
                else if(colIn.toUpperCase().equals("BLUE")){
                    colSel = ColorCode.BLUE;
                }
                else {
                    System.out.println("Ungültige Angabe\n");
                    continue;
                }

                System.out.println("  Enter value (0-255");
                String valSel = sc.next();
                model.changeColorViaRelativeValue(colSel, valSel);
                System.out.println(model.toString());
            }

            else if(input.equals("?")){
                System.out.println("Red: " + model.getRed());
                System.out.println("Green: " + model.getGreen());
                System.out.println("Blue: " + model.getBlue());
                System.out.println("Hex: " + model.getHex());
            }

            else if(input.equals("q")){
                break;
            }

            else{
                System.out.println("invalid input");
                continue;
            }

        }

    }

}
