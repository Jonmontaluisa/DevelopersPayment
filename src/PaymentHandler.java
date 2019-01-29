// The following code has been written by Jonathan Montaluisa jonmontaluisa@gmail.com
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PaymentHandler {

    //PaymentHandler reads the input from a txt files and create an array of developers, later it calculates the payment
    //that every developer should receive

    public static PaymentCalculator pC = new PaymentCalculator();

    public static void main( String args[])  {

        List <Developer> developers = new ArrayList<Developer>();
        createDevProfiles(args[0], developers);
        for(Developer dev: developers){
            int paymentForDev = pC.calculatePayment(dev);
            System.out.println("The amount to pay "+dev.getDeveloperName() + " is "+paymentForDev+ " USD");
        }

    }

    public static List<Developer> createDevProfiles(String textFile, List<Developer> developers) {
        try {
            Scanner scn = new Scanner(new File(textFile));
            while(scn.hasNextLine()){
                try {
                    Developer dev = new Developer(scn.nextLine());
                    developers.add(dev);
                }catch (Exception e){
                    System.out.println("incorrect formatting, please refer to README");
                }
            }
            return  developers;

        }
        catch (FileNotFoundException ex){
            System.out.println("no available file");
        }
        return developers;
    }


}
