import java.util.ArrayList;

public class HomeMenu {
    private TextUI ui = new TextUI();
    DB db = new DB();
    public ArrayList<Cats> cats;

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
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\Dyr ice ice ice 2\\Fanimals";
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
                        int lifespan = Integer.parseInt(parameters[2].trim());
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


}
