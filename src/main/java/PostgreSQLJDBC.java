import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

public class PostgreSQLJDBC {
	public static void main(String args[]) {
		Connection c = null;
		PreparedStatement preparedstatement = null;
		try {
			String fileName = "C:/Users/212614073/Desktop/afdata-test.txt";
			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		    FileInputStream fis = null;
		    File file = new File(fileName);
		      fis = new FileInputStream(file);
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/postgres",
							"postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			preparedstatement=c.prepareStatement("insert into osi_pi_asset_schema.historian_asset_model values(?,?,?,?,?)");
			preparedstatement.setInt(1, 123);
			preparedstatement.setString(2, "400");
			preparedstatement.setAsciiStream(3, fis, (int) file.length());
			preparedstatement.setTimestamp(4, timestamp);
			preparedstatement.setString(5, "1e1bdb55-4396-44dd-90ea-65f98fbe22da");
			preparedstatement.executeUpdate();

		
			preparedstatement.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
}