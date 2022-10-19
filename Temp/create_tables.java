package Items_Data;
import java.sql.*;

/*
CSCE 315
9-27-2021 Lab
 */

public class create_tables {

  // Function to create tables
  static String createTable(String table_name, String attrs[], String attr_types[]) {
    String new_table = "CREATE TABLE IF NOT EXISTS " + table_name + " (";
    for (int i = 0; i < attrs.length; i++) {
      new_table += attrs[i] + " " + attr_types[i];
      if (i < attrs.length - 1) {
        new_table += ", ";
      }

    }
    new_table += ");";
    System.out.println(new_table);
    return new_table;
  }

  // Commands to run this script
  // This will compile all java files in this directory
  // javac *.java
  // This command tells the file where to find the postgres jar which it needs to
  // execute postgres commands, then executes the code
  // Windows: java -cp ".;postgresql-42.2.8.jar" jdbcpostgreSQL
  // Mac/Linux: java -cp ".:postgresql-42.2.8.jar" jdbcpostgreSQL

  // MAKE SURE YOU ARE ON VPN or TAMU WIFI TO ACCESS DATABASE
  public static void main(String args[]) {

    // Building the connection with your credentials
    Connection conn = null;
    String teamNumber = "44";
    String sectionNumber = "904";
    String dbName = "csce315_" + sectionNumber + "_" + teamNumber;
    String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
    dbSetup myCredentials = new dbSetup();

    // Connecting to the database
    try {
      conn = DriverManager.getConnection(dbConnectionString, dbSetup.user, dbSetup.pswd);
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }

    System.out.println("Opened database successfully");

    try {
      // create a statement object
      Statement stmt = conn.createStatement();

      // Find what tables are in the database
      String get_tables = """
          SELECT table_name
          FROM information_schema.tables
          WHERE table_schema='public'
          AND table_type='BASE TABLE';""";

      // query for current tables
      ResultSet result = stmt.executeQuery(get_tables);
      ResultSetMetaData rsmd = result.getMetaData();
      int cols = rsmd.getColumnCount();

      // Print current tables
      System.out.println("--------------------Current Tables--------------------");

      while (result.next()) {
        for (int i = 1; i <= cols; i++) {
          if (i > 1)
            System.out.print(", ");
          String columnValue = result.getString(i);
          System.out.print(columnValue + " " + rsmd.getColumnName(i));
        }
        System.out.println("");
      }

      // Create tables

      /* EXAMPLE FOR CREATE TABLE FUNCTION */
      // String[] attrs = {"id", "name", "height"};
      // String[] attrs_type = {"int", "varchar(255)", "int"};
      // String table_name = "teammember";
      // String create_teammember = createTable(table_name, attrs, attrs_type);
      // System.out.println(create_teammember);

      // Print SQL queries for creating tables
      System.out.println("\n--------------------Create Tables--------------------");

      String[] server_attrs = { "employee_id", "pin_code", "fname", "lname" };
      String[] server_attrs_type = { "int PRIMARY KEY", "int CHECK (pin_code > 0 AND pin_code < 10000)", "varchar(255)",
          "varchar(255)" };
      String create_server = createTable("server", server_attrs, server_attrs_type);
      stmt.execute(create_server);

      String[] manager_attrs = { "manager_id", "employee_id" };
      String[] manager_attrs_type = { "int PRIMARY KEY", "int REFERENCES server (employee_id)" };
      String create_manager = createTable("manager", manager_attrs, manager_attrs_type);
      stmt.execute(create_manager);

      String[] orders_attrs = { "order_id", "employee_id", "order_items", "order_time", "cost" };
      String[] orders_attrs_type = { "int PRIMARY KEY", "int REFERENCES server (employee_id)", "varchar(255) ARRAY",
          "date",
          "numeric" };
      String create_orders = createTable("orders", orders_attrs, orders_attrs_type);
      stmt.execute(create_orders);

      String[] menu_attrs = { "item_id", "description", "ingredients", "cost" };
      String[] menu_attrs_type = { "int PRIMARY KEY", "varchar(255)", "varchar(255) ARRAY", "numeric" };
      String create_menu = createTable("menu", menu_attrs, menu_attrs_type);
      stmt.execute(create_menu);

      String[] inventory_attrs = { "item_id", "description", "quantity", "cost" };
      String[] inventory_attrs_type = { "int PRIMARY KEY", "varchar(255)", "int CHECK (quantity >= 0)", "numeric" };
      String create_inventory = createTable("inventory", inventory_attrs, inventory_attrs_type);
      stmt.execute(create_inventory);

      // Privileges for tables
      // Grant access for current tables has to be run everytime a new table is
      // created

      // Print SQL queries for creating tables
      System.out.println("\n--------------------Grant Privileges--------------------");

      String[] users = { "csce315_904_nguyen", "csce315_904_do_cao", "csce315_904_williamson", "csce315_904_martinez",
          "csce315_904_garza" };
      for (String user : users) {
        String grant_access = "GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO ";
        grant_access += user + ";";
        System.out.println(grant_access);
        stmt.execute(grant_access);
      }


    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }

    // closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch (Exception e) {
      System.out.println("Connection NOT Closed.");
    } // end try catch
  }// end main
}// end Class
