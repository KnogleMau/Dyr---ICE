import java.sql.*;
import java.util.ArrayList;

public class DB {
    Connection con;

    public void connect(String url) {
        try {
            con = DriverManager.getConnection(url);
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> selectCats() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "SELECT id, species, origin, lifeSpan, temper, AllergyFriendly FROM Cat";

        try {
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String row = rs.getInt("id") + " , " + rs.getString("species") + " , " +
                        rs.getString("origin") + " , " + rs.getInt("lifeSpan") + " , " +
                        rs.getString("temper") + " , " + rs.getString("AllergyFriendly");
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList<String> selectDogs() {
        ArrayList<String> dogData = new ArrayList<>();
        String sql = "SELECT id, species, cost, lifespan, temper, AllergyFriendly FROM Dog";

        try {
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String row = rs.getInt("id") + " , " + rs.getString("species") + " , " +
                        rs.getString("cost") + " , " + rs.getInt("lifespan") + " , " +
                        rs.getString("temper") + " , " + rs.getString("AllergyFriendly");
                dogData.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dogData;
    }

    public String checkLogIn(String usernameInput, String passwordInput) {

        String sql = "SELECT username, password FROM Login";


        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String userTarget = rs.getString("username");
                String passwordTarget = rs.getString("password");
                if (usernameInput.equals(userTarget)) {
                    if (passwordInput.equals(passwordTarget)) {
                        System.out.println("Login Vellykket");
                        return "Login Vellykket";
                    } else {
                        System.out.println("login fejllykket");
                        return "Wrong password";
                    }
                }
                System.out.println("Username not found");
                return "Username not found";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Login failed";
        }
        return sql;
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
}


