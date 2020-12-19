import java.sql.*;
import java.util.Scanner;

public class DemoClass {
    public static void main(String[] args)

    {

        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("enter username");
            String uname = sc.next();


            Scanner sc2 = new Scanner(System.in);
            System.out.println("enter pass");
            String pass = sc2.next();


            Scanner sc3 = new Scanner(System.in);
            System.out.println("enter connection string");
            String url = sc3.next();



            System.out.println("your username is: " + uname);
            System.out.println("connection string: " + url);

            String query = "SELECT * FROM public.f_sales LIMIT 5";

            System.out.println("Connecting to database...");
            Connection con = DriverManager.getConnection(url,uname,pass);
            Statement st = con.createStatement();

            System.out.println("Querying the database...");
            ResultSet rs = st.executeQuery(query);
            rs.next();

            print_query_results(rs);

            st.close();
            con.close();
        }

        catch (Exception e) {
            System.out.println("***Something went wrong***: " + e);
        }

    }



    private static void print_query_results(ResultSet rs) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }


}

