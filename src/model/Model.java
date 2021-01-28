/**class Model
 * @author Matteo Falkenberg
 * @version 1.9, 28.01.2021
 */

package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Model {

    private ModularCounter red = new ModularCounter(0, 256);
    private ModularCounter green = new ModularCounter(0, 256);
    private ModularCounter blue = new ModularCounter(0, 256);

    public Model(){

    }


    public void loadFromFile(){
        String s;
        int colNum = 0;
        try{
            FileReader fr = new FileReader("./saveFiles/colorValues.txt");
            BufferedReader br = new BufferedReader(fr);
            while((s = br.readLine()) != null){
                if(colNum == 0)
                    changeColorViaAbsoluteValue(ColorCode.RED, s);
                else if(colNum == 1)
                    changeColorViaAbsoluteValue(ColorCode.GREEN, s);
                else if(colNum == 2) {
                    changeColorViaAbsoluteValue(ColorCode.BLUE, s);
                    break;
                }
                colNum++;
            }
            br.close();
            fr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void saveToFile(){
        try{
            FileWriter fw = new FileWriter("./saveFiles/colorValues.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("" + red.getValue());
            bw.newLine();
            bw.write("" + green.getValue());
            bw.newLine();
            bw.write("" + blue.getValue());
            bw.close();
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void changeColorViaAbsoluteValue(ColorCode cc, String value){
        int valInt = Integer.parseInt(value);

        changeColorViaAbsoluteValue(cc, valInt);
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, int value){

        if(cc.equals(ColorCode.RED) && value >= 0 && value <= 255){
            red.reset();
            red.inc(value);
        }

        else if(cc.equals(ColorCode.GREEN) && value >= 0 && value <= 255){
            green.reset();
            green.inc(value);
        }

        else if(cc.equals(ColorCode.BLUE) && value >= 0 && value <= 255){
            blue.reset();
            blue.inc(value);
        }

        else System.out.println("invalid input");
    }


    public void changeColorViaRelativeValue(ColorCode cc, String value){
        int valInt = Integer.parseInt(value);

        changeColorViaRelativeValue(cc, valInt);
    }

    public void changeColorViaRelativeValue(ColorCode cc, int value){

        if(cc.equals(ColorCode.RED)){
            if(value > 0) {
                if (red.getValue() + value > 255) {    //if value of red goes over 255 add rest-1 from 0
                    value = red.getValue() + value - 256;
                    red.reset();
                    red.inc(value);
                    return;
                }
                red.inc(value);
            }
            else if(value < 0) {
                value = value * (-1);
                if (red.getValue() - value < 0) {  //if value of red goes beneath 0 decrease rest-1 from 255
                    value = red.getValue() - value + 256;
                    red.reset();
                    red.inc(value);
                    return;
                }
                red.dec(value);
            }

        }

        else if(cc.equals(ColorCode.GREEN)){
            if(value > 0) {
                if (green.getValue() + value > 255) {    //if value of green goes over 255 add rest-1 from 0
                    value = green.getValue() + value - 256;
                    green.reset();
                    green.inc(value);
                    return;
                }
                green.inc(value);
            }
            else if(value < 0) {
                value = value * (-1);
                if (green.getValue() - value < 0) {  //if value of green goes beneath 0 decrease rest-1 from 255
                    value = green.getValue() - value + 256;
                    green.reset();
                    green.inc(value);
                    return;
                }
                green.dec(value);
            }
        }

        else if(cc.equals(ColorCode.BLUE)){
            if(value > 0) {
                if (blue.getValue() + value > 255) {    //if value of green goes over 255 add rest-1 from 0
                    value = blue.getValue() + value - 256;
                    blue.reset();
                    blue.inc(value);
                    return;
                }
                blue.inc(value);
            }
            else if(value < 0) {
                value = value * (-1);
                if (blue.getValue() - value < 0) {  //if value of green goes beneath 0 decrease rest-1 from 255
                    value = blue.getValue() - value + 256;
                    blue.reset();
                    blue.inc(value);
                    return;
                }
                blue.dec(value);
            }
        }

        else System.out.println("invalid input");
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

        String hex = String.format("#%02X%02X%02X", r, g, b);
        return hex;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Model[red=" + red.getValue() + "(mod " + red.getModulus() + "), ");
        sb.append("green=" + green.getValue() + "(mod " + green.getModulus() + "), ");
        sb.append("blue=" + blue.getValue() + "(mod " + blue.getModulus() + ")}");
        return sb.toString();
    }


    public static void main(String[] args){
        Model model = new Model();
        System.out.println("State: " + model.toString() + "\n");

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Menu");
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

                System.out.println("  Enter value (0-255)");
                String valSel = sc.next();
                model.changeColorViaAbsoluteValue(colSel, valSel);
                System.out.println("State: " + model.toString() + "\n");
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

                System.out.println("  Enter value");
                String valSel = sc.next();
                model.changeColorViaRelativeValue(colSel, valSel);
                System.out.println("State: " + model.toString() + "\n");
            }

            else if(input.equals("?")){
                System.out.println("Red: " + model.getRed());
                System.out.println("Green: " + model.getGreen());
                System.out.println("Blue: " + model.getBlue());
                System.out.println("Hex: " + model.getHex() + "\n");
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
