public class Login {

    DB db = new DB();
    TextUI ui = new TextUI();


    public void loginOption(String username, String password){
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\Dyr ice ice ice 2\\Fanimals";
        db.connect(url);

        db.checkLogIn(username, password);
    }

    public void createUser(String username, String password) {
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\Dyr ice ice ice 2\\Fanimals";
        db.connect(url);


        db.newUser(username, password);

    }

}
