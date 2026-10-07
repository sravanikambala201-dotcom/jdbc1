import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class create{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sravani",
                    "root",
                    "sravani1609"
            );

            System.out.println("dbConnected");

            Statement st = con.createStatement();

            st.executeUpdate(
                    "CREATE TABLE student(" +
                            "id INT, " +
                            "name VARCHAR(100), " +
                            "salary INT)"
            );

            System.out.println("Table Created");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
