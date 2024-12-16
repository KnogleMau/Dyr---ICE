public class Jobs {
    public String headLine;
    public String description;
    public int salaryHour;
    public String location;
    TextUI ui = new TextUI();
    DB db = new DB();

public void createJobs(){
    var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\Dyr ice ice ice 2\\Fanimals";
    db.connect(url);

            String mHeadLine = ui.promptText("Headline");
            String mDescription = ui.promptText("Description");
            int mSalaryHour = Integer.parseInt(ui.promptText("Salary"));
            String mLocation = ui.promptText("Location");
     db.MakeJobs(mHeadLine, mDescription, mSalaryHour, mLocation);


}


}
