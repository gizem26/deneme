package staj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Staj1 {

    public static void main(String[] args) throws Exception {

        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/ogrenci";
            String username = "root";
            String password = "root";

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from ogrenci");

            writeResultset(resultSet);

            //resultSet = preparedStatement.executeQuery();
            //writeResultSet(resultSet);
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void writeResultset(ResultSet resultSet) throws SQLException {
        String user ="";
        while (resultSet.next()) {
            user += resultSet.getString("id") +  " - " ;
        }
         System.out.println(user);        
    } 

}
