public class Login {

    DB db = new DB();
    TextUI ui = new TextUI();


    public void loginOption(){
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\Dyr ice ice ice 2\\Fanimals";
        db.connect(url);

        String usernameInput1 = ui.promptText("username");
        String passwordInput1 = ui.promptText("password");
        db.checkLogIn(usernameInput1, passwordInput1);
    }

    public void createUser() {
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\Dyr ice ice ice 2\\Fanimals";
        db.connect(url);

     boolean input =   ui.promptBinary("Vil du gerne lave en Bruger?" + "Y/N");
        if (input == true) {
            String usernameInput = ui.promptText("lav et username");
                    String passwordInput = ui.promptText("lav et password");
            db.newUser(usernameInput, passwordInput);
        } else {
            boolean input1 = ui.promptBinary("vil du istedet logIn?" + "Y/N");
            if(input1 == true){
                loginOption();

            }
        }
    }
}
