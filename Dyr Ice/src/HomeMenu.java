import java.sql.SQLOutput;
import java.util.ArrayList;

public class HomeMenu {
    private TextUI ui = new TextUI();
    DB db = new DB();
    public ArrayList<Cats> cats;
    public ArrayList<Dogs> dogs;

    public String displaySearchMenu(String choice, String input2) {
        HomeMenu h = new HomeMenu();
        ArrayList<String> dogList = h.readDogsList();
        h.createDogList(dogList);
        String result = "";

        switch(choice) {
            case "1":
                 result = String.valueOf(getDogsBySpecies(input2));

                break;

            case "2":
                result = String.valueOf(getDogsByLifespan(input2));
                break;

            case "3":
                result = String.valueOf(getDogsByTemper(input2));
                break;

            case "4":
                result = String.valueOf(getDogsByAllergy(input2));
                break;
            default:
                result = "Ugyldigt valg.";
        }
        return result;
    }

    public ArrayList<String> readCatsList() {
        var url = "jdbc:sqlite:C:\\Users\\thran\\Desktop\\Datamatiker\\1.Semester\\Dyr---ICE\\Fanimals";
        db.connect(url);
        ArrayList<String> catList = db.selectCats();

        return catList;
    }

    public ArrayList<Cats> createCatList(ArrayList<String> catList) {
        cats = new ArrayList<>();
        for (int i = 0; i < catList.size(); i++) {
            String line = catList.get(i);

            if (!line.isEmpty() && line.contains(":")) {
                String[] parameters = line.split(":");
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
        return cats;
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
        var url = "jdbc:sqlite:C:\\Users\\thran\\Desktop\\Datamatiker\\1.Semester\\Dyr---ICE\\Fanimals";
        db.connect(url);
        ArrayList<String> dogList = db.selectDogs();
        return dogList;
    }

    public ArrayList<Dogs> createDogList(ArrayList<String> dogList) {
        dogs = new ArrayList<>();
        for (int i = 0; i < dogList.size(); i++) {
            String line = dogList.get(i);

            if (!line.isEmpty() && line.contains(" , ")) {
                String[] parameters = line.split(" , ");
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
