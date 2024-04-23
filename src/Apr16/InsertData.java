package Apr16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO users (name, email) VALUES (?,?) RETURNING *"
             )) {
            String name = "Cherry Lyn";
            String email = "cherry@cit.edu";
            statement.setString(1, name);
            statement.setString(2, email);
            int rowsInserted = statement.executeUpdate();
            System.out.println("Rows Inserted: " + rowsInserted);
            ResultSet res = statement.getResultSet();
            while (res.next()) {
                int id2 = res.getInt("id");
                String name2 = res.getString("name");
                String email2 = res.getString(3);
                System.out.println("ID: " + id2 + "\nName: " +
                        name2 + "\nEmail: " + email2 + "\n");
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }
}
