import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class update {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sravani",
                    "root",
                    "sravani1609"
            );

            String sql = "UPDATE employee SET salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 55000);
            ps.setInt(2, 101);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Row Updated Successfully");
            } else {
                System.out.println("No Record Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}