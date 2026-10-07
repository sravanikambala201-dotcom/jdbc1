import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class delete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sravani",
                    "root",
                    "sravani1609"
            );

            String sql = "DELETE FROM employee WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Row Deleted Successfully");
            } else {
                System.out.println("No Record Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}