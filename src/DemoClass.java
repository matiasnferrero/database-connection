import java.sql.*;
import java.util.Scanner;

public class DemoClass {


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


    public static void main(String[] args)

    {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("enter username");
            String uname = sc.next();

            System.out.println("enter pass");
            String pass = sc.next();

            System.out.println("enter connection string");
            String url = sc.next();

            System.out.println("enter query");
            sc.nextLine(); //this is to move the cursor to the next line
            String query = sc.nextLine();


            System.out.println("your username is: " + uname);
            System.out.println("connection string: " + url);

            boolean isFound = query.contains("LIMIT");


            if (isFound==false) {
                int MAX_RESULTS = 5;
                System.out.println("you didnt pass a LIMIT. Setting LIMIT to " + MAX_RESULTS + " to not overload the RAM");
                query = query + " LIMIT " + MAX_RESULTS;
            }


            System.out.println("Connecting to database...");
            Connection con = DriverManager.getConnection(url,uname,pass);
            Statement st = con.createStatement();

            System.out.println("Running query: " + query);
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






}

