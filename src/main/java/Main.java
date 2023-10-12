import java.sql.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //1. Load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. Establish the connection with the database:
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root", "");

        //3. Create the statement object
        Statement st = con.createStatement();

        boolean flag = true;
        while (flag) {
            System.out.println("Enter the choice: ");
            System.out.println("1. View the scoreboard");
            System.out.println("2. Insert a new record");
            System.out.println("3. Update a record");
            System.out.println("4. Delete a record");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewTable(st);
                case 2 -> insertRecord(st, sc);
                case 3 -> updateTable(st, sc);
                case 4 -> deleteRecord(st, sc);
                default -> flag = false;
            }
        }
    }

    public static void viewTable(Statement st) throws Exception {
        String sql = "select * from scoretable;";
        ResultSet rs = st.executeQuery(sql);

        System.out.println("ID\t | NAME\t | RUNS\t | BALLS\t");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getInt(3) + "\t" +
                    rs.getInt(4));
            System.out.println("---------------------------------");
        }
    }

    public static void insertRecord(Statement st, Scanner sc) throws Exception {
        // INSERT into scoretable VALUES (1,"Kushal",127,121);
        System.out.println("Enter the id:");
        int id = sc.nextInt();
        System.out.println("Enter the name of the player:");
        String name = sc.next();
        System.out.println("Enter the runs scored:");
        int runs = sc.nextInt();
        System.out.println("In how many balls??");
        int balls = sc.nextInt();

        String str = "INSERT into scoretable VALUES (" + id + ", '" + name + "', " + runs + ", " + balls + ")";
        int rows = st.executeUpdate(str);

        System.out.println(rows + " rows inserted");
        System.out.println("---------------------------------");
    }

    public static void updateTable(Statement st, Scanner sc) throws Exception {
        System.out.println("Enter the id of the player:");
        int id = sc.nextInt();
        System.out.println("Enter the new runs:");
        int runs = sc.nextInt();
        System.out.println("In how many balls??");
        int balls = sc.nextInt();

        String updateQuery = "UPDATE scoretable SET runs = " + runs + ", balls = " + balls + " WHERE id = " + id;
        int rows = st.executeUpdate(updateQuery);
        System.out.println(rows + " rows updated");
        System.out.println("---------------------------------");
    }

    public static void deleteRecord(Statement st, Scanner sc) throws Exception {
        System.out.println("Enter the id of the player:");
        int id = sc.nextInt();

        String deleteQuery = "DELETE from scoretable where id = " + id;
        int rows = st.executeUpdate(deleteQuery);
        System.out.println(rows + " rows deleted");
        System.out.println("---------------------------------");
    }
}
