import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sravani",
                    "root",
                    "sravani1609"
            );

            String sql = "INSERT INTO employee(id, name, salary) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);
            ps.setString(2, "laxmi");
            ps.setInt(3, 50000);
            ps.addBatch();

            ps.setInt(1, 102);
            ps.setString(2, "naveen");
            ps.setInt(3, 60000);
            ps.addBatch();

            int rows[] = ps.executeBatch();

            if (rows.length > 0) {
                System.out.println(rows.length + " rows Inserted");
            }

            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
