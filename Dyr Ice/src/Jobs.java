import java.util.ArrayList;

public class Jobs {
    public String headLine;
    public String description;
    public int salaryHour;
    public String location;
    TextUI ui = new TextUI();
    DB db = new DB();

    public ArrayList<String> readJobs() {
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\LORTEPROJEKT\\Animals";
        db.connect(url);
        ArrayList<String> jobs = db.selectJobs();

        return jobs;
    }

    public void createJobs() {
        var url = "jdbc:sqlite:C:\\Users\\Mavso\\IdeaProjects\\LORTEPROJEKT\\Animals";
        db.connect(url);

        String mHeadLine = ui.promptText("Headline");
        String mDescription = ui.promptText("Description");
        int mSalaryHour = Integer.parseInt(ui.promptText("Salary"));
        String mLocation = ui.promptText("Location");
        db.MakeJobs(mHeadLine, mDescription, mSalaryHour, mLocation);
    }

    public void printJobList() {
        if (!readJobs().isEmpty()) {
            for (String s: readJobs()) {
                System.out.println(s);
            }
        } else {
            System.out.println("No jobs shows");
        }
    }
}