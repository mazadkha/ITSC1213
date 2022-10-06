import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class holds all the exception which can occur in this project.
 * @author Mohammad Azad | mazad@uncc.edu
 * Professor - Geoffrey Grimaud
 */
public class Excptns {

    /**
     * This Exception handler handles InputMismatchException for any double value.
     * It has a while loop for letting the user enter values till the valid input is entered.
     * @return Double - The Double value as price.
     */
    public static double invalidDouble(){
        double price = 0;
        boolean isEx = true;
        do{
            try {
                Scanner scnr = new Scanner(System.in);
                price = scnr.nextDouble();
                isEx = false;
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input, Try again: ");
            }
        }while(isEx);
        return price;
    }
    
    /**
     * This Exception handler handles InputMismatchException for any int value.
     * It has a while loop for letting the user enter values till the valid input is entered.
     * @return Integer - This will be any correct int value. 
     */
    public static int invalidInt(){
        int number = 0;
        boolean isEx = true;
        do{
            try {
                Scanner scnr1 = new Scanner(System.in);
                number = scnr1.nextInt();
                isEx = false;
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input, Try again: ");
            }
        }while(isEx);
        return number;
    }
    
    /**
     * This Exception handler handles FileNotFoundException for any String name typed.
     * It has a while loop for letting the user enter values till the valid input is entered.
     * @return String - This will be the file name that was successfully found.
     */
    public static String fileNotFoundExc(){
        String filename = null;
        
        boolean exc = true;
        while(exc){
            try {
                Scanner scnr = new Scanner(System.in);
                filename = scnr.nextLine();
                Scanner input = new Scanner(new File(filename));
                exc = false;
            }catch(FileNotFoundException e){
                System.out.print("File not found, Try again: ");
            }
        }
        return filename;
    }
    
    /**
     * This Exception handler handles when scanner reads the file.It catches an exception when the value is not a double after the string has been parsed.
     * @param srt this will hold the value in a string format will be used to Parse double value
     * @return double - This will be the successfully parsed double value from String.
     */
    public static double stringToDouble(String srt){
        try{
            double value = Double.parseDouble(srt);
            
            return value;
        }catch(NumberFormatException e){
            System.out.println("---------- not a double value");
        }
        return -1;
    }
    
    /**
     * This Exception handler handles when scanner reads the file.It catches an exception when the value is not a int after the string has been parsed.
     * @param srt this will hold the value in a string format will be used to Parse integer value
     * @return Integer - This will be the successfully parsed int value from String. 
     */
    public static int stringToInt(String srt){
        try{
            int value = Integer.parseInt(srt);
            return value;
        }catch(NumberFormatException e){
            System.out.println("---------- not a double value");
        }
        return -1;
    }
    
    /**
     * This method checks for duplicate members when adding a new member to the members list.
     * @param id this method excepts an integer which is compared to other integer values
     * @return Boolean - This will be either true or false if there is duplicate members. 
     */
    public static boolean checkDuplicateMember(int id){
        Inventory inventory = new Inventory();
        for(Member member : inventory.getMember()){
            if(member.getId() == id){
                System.out.println("Diplicate member found: " + id+"\n\tNot added to the list");
                return true;
            }
        }
        return false;
    }
}
