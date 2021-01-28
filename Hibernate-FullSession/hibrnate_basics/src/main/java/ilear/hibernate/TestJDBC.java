package ilear.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/ilearn?userSSL=false";
        String user = "root";
        String pwd = "sqlpass";

        try{
            Connection conn = DriverManager.getConnection(jdbcUrl,user,pwd);
            System.out.println("successfull");
        }
        catch (Exception e)
        {
             e.printStackTrace();
        }
    }
}
