import java.util.Scanner;
import java.util.stream.Stream;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    public void displayMsg(String msg){
        System.out.println(msg);
    }

    public int promptNumeric(String msg){
        System.out.println(msg);
        String input = scan.nextLine();
        int numbers;
        try{
            numbers = Integer.parseInt(input);

        }catch(NumberFormatException e){
            displayMsg("Type a number");
            numbers = promptNumeric(msg);
        }
        return numbers;
    }

    public boolean promptBinary(String msg){
        String input = promptText(msg);
        if(input.equalsIgnoreCase("Y")){
            return true;
        }
        else if(input.equalsIgnoreCase("N")){
            return false;
        }
        return promptBinary(msg);
    }

    public String promptText(String msg){
        System.out.println(msg);//Stille brugeren et spørgsmål
        String input = scan.nextLine();
        return input;
    }
}
