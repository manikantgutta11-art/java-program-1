
import java.sql.*;

public class JDBCDeleteExample {

    // Database connection details
    static final String JDBC_URL =
        "jdbc:mysql://localhost:3306/mydatabase";

    static final String USERNAME = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        // User ID to delete
        int userId = 2;

        // SQL DELETE query
        String deleteQuery =
            "DELETE FROM users WHERE id = ?";

        try (
            Connection connection =
                DriverManager.getConnection(
                    JDBC_URL, USERNAME, PASSWORD
                );

            PreparedStatement pstmt =
                connection.prepareStatement(deleteQuery)
        ) {

            // Set user ID parameter
            pstmt.setInt(1, userId);

            // Execute DELETE query
            int rowsAffected = pstmt.executeUpdate();

            // Check deletion result
            if (rowsAffected > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }

        } catch (SQLException e) {

            System.out.println(
                "Database Error: " + e.getMessage()
            );
        }
    }
}
