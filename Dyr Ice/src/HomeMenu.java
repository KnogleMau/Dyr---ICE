import java.sql.SQLOutput;
import java.util.ArrayList;

public class HomeMenu {
    private TextUI ui = new TextUI();
    DB db = new DB();
    public ArrayList<Cats> cats;
    public ArrayList<Dogs> dogs;

    public void displayMenu() {
        int choice = ui.promptNumeric("Type a number:");

        switch (choice) {
            case 1:
                // search methods
                break;
            case 2:
                // jobs.method
                break;
            case 3:
                // profile
                break;
            case 4:
                //logout
                break;
            default:
                System.out.println("invalid, type a number");
                displayMenu();
        }
    }

    public ArrayList<String> readCatsList() {
        var url = "jdbc:sqlite:identifier.sqlite";
        db.connect(url);
        ArrayList<String> catList = db.selectCats();

        return catList;
    }

    public ArrayList<Cats> createCatList(ArrayList<String> catList) {
        cats = new ArrayList<>();
        for (int i = 0; i < catList.size(); i++) {
            String line = catList.get(i);

            if (!line.isEmpty() && line.contains(";")) {
                String[] parameters = line.split(";");
                if (parameters.length == 5) {
                    try {
                        String species = parameters[0].trim();
                        String origin = parameters[1].trim();
                        String lifespan = parameters[2].trim();
                        String temper = parameters[3].trim();
                        String allergyFriendly = parameters[4].trim();

                        Cats c = new Cats(species, origin, lifespan, temper, allergyFriendly);
                        this.cats.add(c);
                    } catch (NumberFormatException e) {
                        System.out.println("Fejl ved parsing af tal i linje: " + line);
                    }
                }
            }
        }
        return null;
    }

    public void printCatList() {
        // Hvis listen ikke er tom, print alle Cats objekterne
        if (!cats.isEmpty()) {
            for (Cats c : cats) {
                System.out.println(c);  // Forudsat at Cats har en toString() metode
            }
        } else {
            System.out.println("Ingen katte at vise.");
        }
    }

    public ArrayList<String> readDogsList(){
        var url = "jdbc:sqlite:identifier.sqlite";
        db.connect(url);
        ArrayList<String> dogsList = db.selectDogs();
        return dogsList;
    }

    public ArrayList<Dogs> createDogList(ArrayList<String> dogList) {
        dogs = new ArrayList<>();
        for (int i = 0; i < dogList.size(); i++) {
            String line = dogList.get(i);

            if (!line.isEmpty() && line.contains(";")) {
                String[] parameters = line.split(";");
                if (parameters.length == 5) {
                    try {
                        String species = parameters[0].trim();
                        String cost = parameters[1].trim();
                        String lifespan = parameters[2].trim();
                        String temper = parameters[3].trim();
                        String allergyFriendly = parameters[4].trim();

                        Dogs d = new Dogs(species, cost, lifespan, temper, allergyFriendly);
                        this.dogs.add(d);
                    } catch (NumberFormatException e) {
                        System.out.println("failed parsing in the line: ");
                    }
                }
            }
        }
        return dogs;
    }

    public void printDogsList() {
        if (!dogs.isEmpty()) {
            for (Dogs d : dogs) {
                System.out.println(d);
            }
        } else {
            System.out.println("no dogs shows");
        }
    }

    // cats search
    public Cats getCatsBySpecies(String s) {
        for(Cats c : cats) {
            if(c.getSpecies().equalsIgnoreCase(s)){
                return c;
            }
        } return null;
    }

    public Cats getCatsByOrigin(String s) {
        for(Cats c : cats) {
            if(c.getOrigin().equalsIgnoreCase(s)){
                return c;
            }
        } return null;
    }

    public Cats getCatsByLifeSpan(String s){
        String soeg = s;
        for(int i = 0; i < cats.size(); i++)
        {
            if(((Cats) cats.get(i)).getLifeSpan().contains(soeg))
            {
                System.out.println(cats.get(i));

            }
        }
        return null;
    }

    public Cats getCatsByTemper(String s){
        String soeg = s;
        for(int i = 0; i < cats.size(); i++)
        {
            if(((Cats) cats.get(i)).getTemper().contains(soeg))
            {
                System.out.println(cats.get(i));

            }
        }
        return null;
    }

    public Dogs getCatsByAllergy(String s){
        for (Dogs c: dogs){
            if (c.getAllergyFriendly().equalsIgnoreCase(s)){
                return c;
            }
        }
        return null;
    }

    // dog search

    public Dogs getDogsBySpecies(String s) {
        for(Dogs c : dogs) {
            if(c.getSpecies().equalsIgnoreCase(s)){
                return c;
            }
        } return null;
    }

    public Dogs getDogsByCost(String s) {
        for(Dogs c : dogs) {
            if(c.getCost().equalsIgnoreCase(s)){
                return c;
            }
        } return null;
    }


    public Dogs getDogsByLifespan(String s){
        String soeg = s;
        for(int i = 0; i < dogs.size(); i++)
        {
            if(((Dogs) dogs.get(i)).getLifeSpan().contains(soeg))
            {
                System.out.println(dogs.get(i));

            }
        }
        return null;
    }


    public Dogs getDogsByTemper(String s){
        String soeg = s;
        for(int i = 0; i < dogs.size(); i++)
        {
            if(((Dogs) dogs.get(i)).getTemper().contains(soeg))
            {
                System.out.println(dogs.get(i));

            }
        }
        return null;
    }

    public Dogs getDogsByAllergy(String s){
        for (Dogs c: dogs){
            if (c.getAllergyFriendly().equalsIgnoreCase(s)){
                return c;
            }
        }
        return null;
    }
}
