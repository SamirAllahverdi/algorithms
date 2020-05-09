package XSqL;

import java.sql.*;

public class SqlAPP1 {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String NAME = "postgres";
    private final static String PWD = "Samir12345";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, NAME, PWD);

        String username = "Elnare";
        String status = "bachelor";

        String loginSQL = "UPDATE public.person  SET  mone = mone -100 WHERE id = 1";

        PreparedStatement stmt1 = connection.prepareStatement(loginSQL);
        stmt1.executeUpdate();

//        String selectSql = "SELECT * FROM  students";
//        PreparedStatement stmt2 = connection.prepareStatement(selectSql);
//
//        ResultSet resultSet = stmt2.executeQuery();
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("name"));
//        }


    }
}
