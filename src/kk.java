import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class kk {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sravani",
                    "root",
                    "sravani1609"
            );

            System.out.println("Connection Successful!");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("salary")
                );
            }

            // Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
