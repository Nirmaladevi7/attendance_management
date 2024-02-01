import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAndInsertExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(url, user, password);


            String createTableQuery = "CREATE TABLE IF NOT EXISTS records (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "std_name VARCHAR(255) NOT NULL," +
                    "std_id INT NOT NULL," +
                    "present BOOLEAN NOT NULL)";

            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery)) {
                createTableStatement.execute();
            }


            String insertQuery = "INSERT INTO records (std_name, std_id, present) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                preparedStatement.setString(1, "nirmala");
                preparedStatement.setInt(2, 13);
                preparedStatement.setBoolean(3, false);
                preparedStatement.setString(1, "priya");
                preparedStatement.setInt(2, 14);
                preparedStatement.setBoolean(3, true);
                preparedStatement.setString(1, "Bhavani");
                preparedStatement.setInt(2, 15);
                preparedStatement.setBoolean(3, true);
                preparedStatement.setString(1, "Harini");
                preparedStatement.setInt(2, 16);
                preparedStatement.setBoolean(3, true);


                preparedStatement.executeUpdate();
            }


            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
