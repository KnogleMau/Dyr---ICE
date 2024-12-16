import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;

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
                        // input.add(dogGender);  // skal måske sikre at den kun adder til index 0
                    } else  {
                        System.out.println("Please type: [1] or [2] to continue");
                        promptNumericDogNameTraits(1);
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
                        // input.add(dogSize);  // skal måske sikre at den kun adder til index 1
                    }
                    else  {
                        System.out.println("Please type: [1] or [2] to continue");
                        promptNumericDogNameTraits(2);
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

                        //  input.add(nameType);  // skal måske sikre at den kun adder til index 2
                    }
                    else {

                        System.out.println("You can only press: [1], [2] or [3]");
                        promptNumericDogNameTraits(3);
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
        int traitChoice = Integer.parseInt(userChoice);

        if (msg.contains("genres")){
            trait = 1;
            if(traitChoice < 1 || traitChoice > 7){
                System.out.println("select a number between 1 and 7");
                selectSpecificTraits(msg);
            }
        }
        else if(msg.contains("personallyties")){
            trait = 2;
            if(traitChoice < 1 || traitChoice > 7){
                System.out.println("select a number between 1 and 4");
                selectSpecificTraits(msg);
            }
        }
        else if(msg.contains("appearances")) {
            trait = 3;
            if (traitChoice < 1 || traitChoice > 6) {
                System.out.println("select a number between 1 and 6");
                selectSpecificTraits(msg);
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
            case 5:
                if (trait == 1) {
                    selectedTrait = "farm";
                }
                else if (trait == 3){
                    selectedTrait = "white";
                }
            case 6:
                if (trait == 1) {
                    selectedTrait = "agillity";
                }
                else if (trait == 3){
                    selectedTrait = "furry";
                }
            case 7:
                if (trait == 1) {
                    selectedTrait = "family";
                }
        }
        return selectedTrait;
    }
}
