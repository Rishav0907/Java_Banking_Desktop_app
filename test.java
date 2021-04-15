import java.sql.*;

public class test {
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
}