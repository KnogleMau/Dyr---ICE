import java.sql.SQLOutput;

public class Login {

    DB db = new DB();
    TextUI ui = new TextUI();

    public boolean loginOption(String username, String password){
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\LORTEPROJEKT\\Animals";
        db.connect(url);

        boolean isLoggedIn = db.checkLogIn(username, password);
        return isLoggedIn;
    }

    public void createUser(String username, String password) {
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\LORTEPROJEKT\\Animals";
        db.connect(url);


        db.newUser(username, password);

    }
    /*public boolean isUserReal(String username){

        var url = "jdbc:sqlite:C:\\Users\\thran\\Desktop\\Datamatiker\\1.Semester\\Dyr---ICE\\Fanimals";
        db.connect(url);

       return !db.isUserExisting(username);-
    }

     */

}
