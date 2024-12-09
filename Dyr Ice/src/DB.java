import java.sql.*;
import java.util.ArrayList;

public class DB {
    Connection con;
    public void connect(String url){
        try{
            con = DriverManager.getConnection(url);
            System.out.println("connected");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<String> selectCats(){
        ArrayList<String> data = new ArrayList<>();
        String sql = "SELECT id, species, origin, lifeSpan, temper, AllergyFriendly FROM Cat";

        try{
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                String row = rs.getInt("id") + " , " + rs.getString("species") + " , " +
                        rs.getString("origin") + " , " + rs.getInt("lifeSpan") + " , " +
                        rs.getString("temper") + " , " + rs.getString("AllergyFriendly");
                data.add(row);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }



}
