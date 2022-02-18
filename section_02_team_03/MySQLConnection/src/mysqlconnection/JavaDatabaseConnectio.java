package mysqlconnection;

import java.sql.*;


/*
 * 1. import ---> java.sql
 * 2. load and register the driver --> com.mysql.jdbc.Driver(connector)
 * 3. Create connection --> connection
 * 4. Create a statement -- > Statement
 * 5. execute the query
 * 6. Process the result
 * 7. Close the connection.
 * 
 */


public class JavaDatabaseConnectio {
///*
//    public static void main(String[] args) throws Exception {
//
//
//        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
//        String uname = "root";
//        String pass = "PackerBoy2005";
//
//        *//* Non-root user
//        String url = "jdbc:mysql://127.0.0.1:3306/?user=section_02_team_03";
//        String uname = "section_02_team_03";
//        String pass = "section_02_team_03";
//        *//*
//
//
//    *//*
//     * It loads the class and runs the static initializer, which creates an instance and register it with Driver manager.
//     * So driver manager allow us to get connected with DB.
//    *//*
//        Class.forName("com.mysql.jdbc.Driver");
//
//
//
//        *//*
//         connection is an interface , we cant create object of an interface directly so we need to search for a class
//         * which implements connection or we need to search method which will give you the instance of connection
//         * we have method getconnection in a class DriverManager
//
//
//        /* set up the connection with mysql database *//*
//
//        Connection conn = DriverManager.getConnection(url, uname, pass);
//
//
//
//        *//* when we want to use fixed query and only values are changing use preparedstatement.*//*
//        PreparedStatement ps = conn.prepareStatement("use mydb;");
//        int count = ps.executeUpdate();
//        ps = conn.prepareStatement("INSERT INTO vendors(vendor_id, company_name, department_id, vendor_name, vendor_phone) VALUES (1, 'Company Name Here', 1, 'Name Here', 4440000);");
//
//        *//* execute query *//*
//        *//* execute update return*//*
//        count = ps.executeUpdate();
//        Statement st = conn.createStatement();
//
//        ResultSet rs = st.executeQuery("SELECT * FROM vendors");
//        while(rs.next()){
//
//            String id = rs.getString("vendor_id");
//            String co_name = rs.getString("company_name");
//            String deptid = rs.getString("department_id");
//            String vend_name = rs.getString("vendor_name");
//            String vend_phone = rs.getString("vendor_phone");
//
//            System.out.println("Vendor Id: " + id);
//            System.out.println("Company Name: " + co_name);
//            System.out.println("Department Id: " + deptid);
//            System.out.println("Vendor Name: " + vend_name);
//            System.out.println("Vendor phone: " + vend_phone);
//
//        }
//
//        ps = conn.prepareStatement("UPDATE vendors SET vendor_name = 'Name Was HERE' WHERE vendor_name = 'Name Here';");
//        count = ps.executeUpdate();
//
//        System.out.println("");
//
//        rs = st.executeQuery("SELECT * FROM vendors");
//        while(rs.next()){
//
//            String id = rs.getString("vendor_id");
//            String co_name = rs.getString("company_name");
//            String deptid = rs.getString("department_id");
//            String vend_name = rs.getString("vendor_name");
//            String vend_phone = rs.getString("vendor_phone");
//
//            System.out.println("Vendor Id: " + id);
//            System.out.println("Company Name: " + co_name);
//            System.out.println("Department Id: " + deptid);
//            System.out.println("Vendor Name: " + vend_name);
//            System.out.println("Vendor phone: " + vend_phone);
//
//        }
//
//        ps = conn.prepareStatement("DELETE FROM vendors WHERE vendor_id = 1;");
//        count = ps.executeUpdate();
//
//        System.out.println("");
//
//        rs = st.executeQuery("SELECT * FROM vendors");
//        while(rs.next()){
//
//            String id = rs.getString("vendor_id");
//            String co_name = rs.getString("company_name");
//            String deptid = rs.getString("department_id");
//            String vend_name = rs.getString("vendor_name");
//            String vend_phone = rs.getString("vendor_phone");
//
//            System.out.println("Vendor Id: " + id);
//            System.out.println("Company Name: " + co_name);
//            System.out.println("Department Id: " + deptid);
//            System.out.println("Vendor Name: " + vend_name);
//            System.out.println("Vendor phone: " + vend_phone);
//
//        }
//        if (count!= 0)
//        {
//            System.out.println("database connection done");
//            System.out.println("record was inserted    ");
//        }
//
//        ps.close();
//        conn.close();
//
//    }*/
}