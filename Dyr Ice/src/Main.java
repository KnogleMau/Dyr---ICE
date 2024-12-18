import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TextUI ui = new TextUI();

       new GUI();

        StartMenu m = new StartMenu();

        String input = ui.promptText("""
                
                1. Søg på Cat
                
                2. Søg på Dog
                
                3. Lav et random navn til hunde eller katte
                
                
                """);


        switch(input) {
            case "1":
            m.catMenu();
            break;

            case "2":
            m.DogMenu();
            break;

            case "3":
            CreateName createName = new CreateName();
            createName.createDogName();
            break;

            default:
        }
        }





      //  Jobs j = new Jobs();
        //j.createJobs();
      // CreateName createName = new CreateName();
        //createName.createDogName(createName.inp1, createName.inp2);

    }
