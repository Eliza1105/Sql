import java.sql.*;

public class H2JDBC {
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        try(
                Connection connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\gk\\Downloads\\JDBC\\H2\\src\\main\\resources\\dbase.db","sa","");
        )//("jdbc:h2:C:\\Users\\itstep\\Downloads\\JDBC\\H2\\src\\main\\resources\\dbase.db","sa","");
        {
            statement = connection.createStatement();
            readAll();
        }
        catch(SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void readAll() throws SQLException {

        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        //Список всех служащих
        ResultSet rs = statement.executeQuery("select name from character");
        while(rs.next())
           // System.out.printf("name: %s",rs.getString("name"));
        System.out.println("name: "+ rs.getString("name"));

    }


}
