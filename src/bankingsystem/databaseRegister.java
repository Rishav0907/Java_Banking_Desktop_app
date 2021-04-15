package bankingsystem;

import javax.swing.plaf.nimbus.State;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class databaseRegister {
    public String MySQL_URL="jdbc:mysql://localhost:3306/bank";
    public String database_username="root";
    public String database_password="89018901";


    public static void main(String[] args) {
         String MySQL_URL="jdbc:mysql://localhost:3306/bank";
         String database_username="root";
         String database_password="89018901";
        System.out.println("Test case");

        String query2="CREATE TABLE IF NOT EXISTS bank_accounts(\n" +
                "    id INT AUTO_INCREMENT NOT NULL,\n" +
                "    First_Name VARCHAR(255) NOT NULL,\n" +
                "    Last_Name VARCHAR(255) NOT NULL,\n" +
                "    Phone_number VARCHAR(255) NOT NULL UNIQUE,\n" +
                "    Password VARCHAR(255) NOT NULL,\n" +
                "    PRIMARY KEY (id)\n" +
                "    );";
        Connection con=null;
        try{
            con=DriverManager.getConnection(MySQL_URL,database_username,database_password);
            if(con!=null)
            {
                System.out.println("Database Connection Successfull");
            }
            Statement st=con.createStatement();
            st.executeQuery(query2);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean userRegistration(String firstName,String lastName, String phoneNumber, String password)
    {
        String hashedPassword=hashPasswordgenerator(password);
        String basic_sql_query="USE bank;";
        String register_sql_query=String.format(
                "INSERT INTO bank_accounts(First_Name, Last_Name,Phone_number,password) VALUES('%s','%s','%s','%s');",
                firstName.toString(),lastName.toString(),phoneNumber.toString(),hashedPassword).toString();
        Connection con=null;
        try{
            con=DriverManager.getConnection(MySQL_URL,database_username,database_password);
            if(con!=null)
            {
                System.out.println("Database Connection Successfull");
                Statement st=con.createStatement();
                st.executeUpdate(register_sql_query);
            }
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    private String hashPasswordgenerator(String plainPass)
    {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(plainPass.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            System.out.println(hexString.toString());
            return  hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
