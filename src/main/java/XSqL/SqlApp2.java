package XSqL;

import org.postgresql.util.PSQLException;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlApp2 {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String NAME = "postgres";
    private final static String PWD = "Samir12345";

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Connection connection = DriverManager.getConnection(URL, NAME, PWD);

        connection.setAutoCommit(false);

        try {
            String SQL = "UPDATE public.person  SET  mone = mone -100 WHERE id = 1";
            String SQL2 = "UPDATE public.person  SET  mone = mone +100 WHERE id = 2";
            Statement statement = connection.createStatement();
            Statement statement2 = connection.createStatement();

            statement.executeUpdate(SQL);
            statement2.executeUpdate(SQL2);

            connection.commit();
        } catch (RuntimeException x) {

            connection.rollback();
        }catch (PSQLException e){
            System.out.println("s");
            e.getServerErrorMessage();
        }

    }
}
