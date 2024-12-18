import java.sql.*;
import java.util.ArrayList;

public class DB {
    Connection con;

    public void connect(String url) {
        try {
            con = DriverManager.getConnection(url);
            System.out.println("connected ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> selectJobs(){
        ArrayList<String> jobsData = new ArrayList<>();
        String sql = "SELECT id, headline, description, salaryHour, location, username, takerName FROM Job";

        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                String rows = rs.getString("headline") + " , " +
                        rs.getString("description") + " , " + rs.getInt("salaryHour") + " , " +
                        rs.getString("location") + " , " + rs.getString("username") + " , " +
                        rs.getString("takerName");
                jobsData.add(rows);
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return jobsData;
    }


    public ArrayList<String> selectCats() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "SELECT species, origin, lifeSpan, temper, AllergyFriendly FROM Cat";

        try {
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String row =  rs.getString("species") + ": " +
                        rs.getString("origin") + ": " + rs.getInt("lifeSpan") + ": " +
                        rs.getString("temper") + ": " + rs.getString("AllergyFriendly");
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }



    public ArrayList<String> selectDogs() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "SELECT species, cost, lifespan, temper, AllergyFriendly FROM Dog";

        try {
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String row = rs.getString("species") + " , " +
                        rs.getString("cost") + " , " + rs.getInt("lifespan") + " , " +
                        rs.getString("temper") + " , " + rs.getString("AllergyFriendly");
                //System.out.println("Adding row: " + row);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public boolean checkLogIn(String usernameInput, String passwordInput) {
        String sql = "SELECT username, password FROM Login";


        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String userTarget = rs.getString("username");
                String passwordTarget = rs.getString("password");
                if (usernameInput.equals(userTarget)) {
                    if (passwordInput.equals(passwordTarget)) {

                        return true;
                    } else {

                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String newUser(String username, String password) {

        if (isUserExisting(username)) {
            System.out.println("Brugernavnet " + username + " er allerede taget. Vælg venligst et andet.");
            return "Username already taken";
        }
        String insertSQL = "INSERT INTO LogIn (username, password) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
            {

                // Set the values for the placeholders
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                // Execute the insert query
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows inserted: " + rowsAffected);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertSQL;
    }

    public boolean isUserExisting(String username) {
        String password = "";
        String sql = "SELECT username FROM LogIn WHERE username = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                System.out.println("Brugeren findes allerede");
                return true;
            } else {
                System.out.println("Brugeren findes ikke");
                return false;
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    public void MakeJobs(String headline, String description, int salaryHour, String location){
        String insertSQL = "INSERT INTO Job(headline, description, salaryHour, location) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
            {

                preparedStatement.setString(1,headline);
                preparedStatement.setString(2,description);
                preparedStatement.setInt(3,salaryHour);
                preparedStatement.setString(4, location);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows inserted: " + rowsAffected);
            }

        }catch(SQLException e){
            e.getMessage();
        }
    }
    public String readJobs(){


        return null;
    }
}


