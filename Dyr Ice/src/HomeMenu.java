public class HomeMenu {
    private TextUI ui = new TextUI();
    
    public void displayMenu(){
        int choice = ui.promptNumeric("Type a number:");

        switch(choice){
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
}
