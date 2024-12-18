import java.util.ArrayList;

public class StartMenu {
    TextUI ui = new TextUI();
HomeMenu h = new HomeMenu();
    public void catMenu(){
        String input2;
        ArrayList<String> catList = h.readCatsList();
        h.createCatList(catList);
      String  choice = ui.promptText("""
                
    Du kan nu vælge følgende kategorier i søgning efter Katte!  
             
                1. Søg efter Species
                
                2. Søg efter levetid!
                
                3. Søg efter Temper
                
                4. Søg efter Allergivenlig
                
                
                """);



        switch(choice) {
            case "1":
                input2 = ui.promptText("Søg på efter Species");
                Cats c = h.getCatsBySpecies(input2);
                System.out.println(c);

                break;

            case "2":
                input2 = ui.promptText("Søg på efter levetid");
                h.getCatsByLifeSpan(input2);
                break;

            case "3":
                input2 = ui.promptText("Søg på efter Temper");
                h.getCatsByTemper(input2);
                break;

            case "4":
                input2 = ui.promptText("Søg på efter Allergivenlig");
                h.getCatsByAllergyfriendly(input2);
                break;
            default:
        }
    }
    public void DogMenu(){
        String input2;
        ArrayList<String> dogList = h.readDogsList();
        h.createDogList(dogList);
        String  choice = ui.promptText("""
                1. Søg efter Species
                
                2. Søg efter levetid!
                
                3. Søg efter Temper
                
                4. Søg efter Allergivenlig
                
                
                """);



        switch(choice) {
            case "1":
                input2 = ui.promptText("Søg på efter Species");
                Dogs d = h.getDogsBySpecies(input2);
                System.out.println(d);

                break;

            case "2":
                input2 = ui.promptText("Søg på efter levetid");
                h.getDogsByLifespan(input2);
                break;

            case "3":
                input2 = ui.promptText("Søg på efter Temper");
                h.getDogsByTemper(input2);
                break;

            case "4":
                input2 = ui.promptText("Søg på efter Allergyfriendly");
                h.getDogsByAllergy(input2);
                break;
            default:
        }
    }
}

