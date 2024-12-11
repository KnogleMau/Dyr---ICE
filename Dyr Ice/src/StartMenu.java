public class StartMenu {
    TextUI ui;

    public void menu(){
        int choice = ui.promptNumeric("Type number 1");

        if(choice == 1){
            // login()
        }else{
            System.out.println("Invalid. Type the number 1");
            menu();
        }
    }
}
