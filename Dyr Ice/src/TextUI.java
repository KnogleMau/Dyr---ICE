import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;

public class TextUI {
    private Scanner scan = new Scanner(System.in);
    CreateName rerunTypeError = new CreateName();

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

    public ArrayList<Integer> promptNumericDogNameTraits(int choice) {

        ArrayList<Integer> input = new ArrayList<>();
        //  input.clear();
        int dogGender =0;
        int dogSize =0;
        int nameType =0;

        switch (choice) {
            case 1: System.out.println("If the gender of the dog is a female press: 1\n If its a male dog press: 2");
                String userChoise = scan.nextLine();
                try {

                    dogGender = Integer.parseInt(userChoise);
                    if(dogGender == 1 || dogGender == 2)
                    {
                        choice = 2;
                        input.add(dogGender);  // skal måske sikre at den kun adder til index 0
                    } else  {
                        System.out.println("Please type: [1] or [2] to continue");
                        promptNumericDogNameTraits(1);
                        // dogGender = 1;
                        //input.add(dogGender);
                        choice = 4;
                    }
                } catch (NumberFormatException e) {
                    displayMsg("Type a number");
                    promptNumericDogNameTraits(1);
                    choice =4;
                }
            case 2: System.out.println("If the name is for a large Dog press: 1\n If its a small dog press: 2");
                String userChoise2 = scan.nextLine();
                try
                {
                    dogSize = Integer.parseInt(userChoise2);
                    if(dogSize == 1 || dogSize == 2)
                    {
                        choice = 2;
                        input.add(dogSize);  // skal måske sikre at den kun adder til index 1
                    }
                    else  {
                        System.out.println("Please type: [1] or [2] to continue");
                        promptNumericDogNameTraits(2);
                        // dogSize =1;
                        // input.add(dogSize);
                        choice = 4;
                    }

                }
                catch (NumberFormatException e) {
                    displayMsg("Type a number");
                    promptNumericDogNameTraits(2);
                    choice = 4;

                }
            case 3: System.out.println("select a combination of two criterias\n" +
                    "Name genre and appearance of the dog. Press: 1 \n" +
                    "Name genre and personality of the dog. Press: 2 \n" +
                    "Appearance and personality of the dog. Press: 3");
                String userChoise3 = scan.nextLine();
                try
                {
                    nameType = Integer.parseInt(userChoise3);
                    if(nameType >= 1 && nameType <= 3)
                    {
                        choice =4;
                        input.add(nameType);

                        //  input.add(nameType);  // skal måske sikre at den kun adder til index 2
                    }
                    else {

                        System.out.println("You can only press: [1], [2] or [3]");
                        //  promptNumericDogNameTraits(3);
                        nameType= 1;
                        input.add(nameType);
                        choice = 4;
                    }
                }
                catch (NumberFormatException e)
                {
                    displayMsg("Type a number");
                    promptNumericDogNameTraits(3);
                    choice = 4;
                }
                break;
        }
        input.add(dogGender);
        input.add(dogSize);
        input.add(nameType);
        return input;
    }

    public String selectSpecificTraits(String msg)
    {
        String selectedTrait ="";
        int trait =0;
        System.out.println(msg);
        String userChoice = scan.nextLine();

        String [] mistypes = {"a","A","b","B","c","C","d","D","e","E","f","g","G","h","H","i","I",
                "j","J", "k","K","l","M","n","N","o","O","p","P","q","Q","r","R","s","S","t","T","u","U",
                "v","V","y","Y","x","X","z","Z","æ","Æ","ø","Ø","å","Å",",",".","<","/","*","-","+","!","@",
                "£","€","&","%","¤","#","(",")","=","?","`","[","]","{","}","_","-",";",":"};
        for(String m: mistypes) {
            if(userChoice.contains(m))
            {
                userChoice ="";
                System.out.println(msg);
                userChoice = scan.nextLine();
            }
        }

        int traitChoice = Integer.parseInt(userChoice);


        if (msg.contains("genres")) {
            trait = 1;
            if (traitChoice < 1 || traitChoice > 7 ) {
                // traitChoice = 5;   til gui uden fejl
                // System.out.println("select a number between 1 and 7");  passer kun med selectSpecificTraits(msg);

                rerunTypeError.createDogName();
                // System.out.println("Type one to exit to Home Menu\n");
                // metodekald til homeMenu på at genkøre koden ved tastefejl
                //   selectSpecificTraits(msg);   første forsøg
            }
        } else if (msg.contains("personalyties")) {
            trait = 2;
            if (traitChoice < 1 || traitChoice > 7) {

                //System.out.println("select a number between 1 and 4");

                rerunTypeError.createDogName();
                //  selectSpecificTraits(msg);
                // traitChoice = 4;  gui nem version uden mulighed for at gengøre metoder efter forkerte bruger inputs
            }
        } else if (msg.contains("appearances")) {
            trait = 3;
            if (traitChoice < 1 || traitChoice > 6) {

                System.out.println("select a number between 1 and 6");
                rerunTypeError.createDogName();
                //  selectSpecificTraits(msg);
                //traitChoice = 3;  til gui som ikke man køres korrekt efter fejl tast fra brugeren

            }
        }


        switch(traitChoice){
            case 1: if(trait == 1){
                selectedTrait = "royal";
            }
            else if(trait == 2){
                selectedTrait = "extrovert";
            }
            else if (trait == 3){
                selectedTrait = "cool";
            }
                break;
            case 2:
                if (trait == 1) {
                    selectedTrait = "predator";
                }
                else if(trait == 2){
                    selectedTrait = "calm";
                }
                else if (trait == 3){
                    selectedTrait = "muscular";
                }
                break;
            case 3:
                if (trait == 1) {
                    selectedTrait = "fantasy";
                }
                else if(trait == 2){
                    selectedTrait = "sneaky";
                }
                else if (trait == 3){
                    selectedTrait = "confused";
                }
                break;
            case 4:
                if (trait == 1) {
                    selectedTrait = "sport";
                }
                else if(trait == 2){
                    selectedTrait = "clumpsy";
                }
                else if (trait == 3){
                    selectedTrait = "black";
                }
                break;
            case 5:
                if (trait == 1) {
                    selectedTrait = "farm";
                }
                else if (trait == 3){
                    selectedTrait = "white";
                }
                break;
            case 6:
                if (trait == 1) {
                    selectedTrait = "agillity";
                }
                else if (trait == 3){
                    selectedTrait = "furry";
                }
                break;
            case 7:
                if (trait == 1) {
                    selectedTrait = "family";
                }
        }
        return selectedTrait;
    }
}