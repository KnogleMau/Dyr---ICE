import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TextUI ui = new TextUI();

        new GUI();

        //HomeMenu h = new HomeMenu();
        //ArrayList<String>dogList = h.readDogsList();
        //h.createDogList(dogList);

        //h.getDogsByTemper(ui.promptText("Søg temper"));

        //h.printDogsList();
        //var url = "jdbc:sqlite:C:\\Users\\thran\\Desktop\\Datamatiker\\1.Semester\\Dyr---ICE\\Fanimals";
        //DB db1 = new DB();
        //db1.connect(url);

        // db1.checkLogIn("1","1");
        //db1.newUser("3","3");
        // Login l = new Login();
        // l.createUser();

        //ArrayList<String> data = db1.selectCats();
        //System.out.println(data);



        /*ArrayList<String>catList = h.readCatsList();
        h.createCatList(catList);
        h.printCatList();*/


      //  Cats c = h.getCatBySpecies(ui.promptText("Hvilken cat vil du gerne søge på?"));

        //Cats c = h.getCatsByTemper(ui.promptText("Søg efter Temper?"));
        //System.out.println(c);



      //  Jobs j = new Jobs();
        //j.createJobs();
       CreateName createName = new CreateName();
        createName.createDogName(createName.inp1, createName.inp2);

    }
}