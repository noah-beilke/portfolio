import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class selectGUI {
    private JButton returnButton;
    public JTextField box1;
    private JButton searchButton;
    private JLabel tableText;
    private JComboBox comboBox;

    private static String table_name;
    private JPanel selectPanel;
    private JLabel labelTit1;
    private JLabel labelTit2;
    private JLabel labelTit3;
    private JLabel labelTit4;
    private JLabel labelTit5;
    private JLabel labelTit6;
    private JLabel labelTit7;
    private JLabel labelTit8;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton resetButton;

    private static JFrame selectFrame;
    private PreparedStatement pst;
    private static Connection con;
    private ResultSet rs;
    private String userType;

    public selectGUI() {

        // return button pressed
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuGUI mainMenu = new mainMenuGUI();
                mainMenu.startUpdate(selectFrame, con, userType);
            }
        });
        // search button pressed
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == null)     // combo box empty
                {
                    JOptionPane.showMessageDialog(null, "Please select a valid ID.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
                else                                        // combo box has an ID selected
                {
                    getInfo(Integer.parseInt((comboBox.getSelectedItem().toString())));
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLabels();
                comboBox.removeAll();
                //refreshItemsFromDB();
            }
        });
    }

    public void startSelect(String tableName, JFrame nframe, Connection inCon, String typeIn)
    {
        con = inCon;
        selectFrame = nframe;
        selectFrame.setContentPane(selectPanel);
        selectFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        selectFrame.getContentPane().setEnabled(true);
        selectFrame.getContentPane().setVisible(true);
        selectFrame.pack();
        selectFrame.getContentPane().revalidate();
        table_name = tableName;
        userType = typeIn;
        tableText.setText(table_name);
        this.setLabels();
        this.refreshItemsFromDB();

    }

    private void setLabels()
    {
        switch(table_name)
        {

            case "Items":   // itemID, name, count, exp, dept, veg, age?
            {
                label1.setVisible(true);
                label1.setText(".");
                labelTit1.setText("Item Name:");
                label2.setVisible(true);
                label2.setText(".");
                labelTit2.setText("Item Count:");
                label3.setVisible(true);
                label3.setText(".");
                labelTit3.setText("Item Expiration:");
                label4.setVisible(true);
                label4.setText(".");
                labelTit4.setText("Department ID:");
                label5.setVisible(true);
                label5.setText(".");
                labelTit5.setText("Vegan?:");
                label6.setVisible(true);
                label6.setText(".");
                labelTit6.setText("Age Requirement?:");
                label7.setVisible(false);
                label7.setText(".");
                labelTit7.setVisible(false);
                label8.setVisible(false);
                label8.setText(".");
                labelTit8.setVisible(false);
                break;
            }
            case "Vendors": // vendorID, comp name, deptid, vendor_name, phone, vendorscol
            {
                label1.setVisible(true);
                label1.setText(".");
                labelTit1.setText("Company Name:");
                label2.setVisible(true);
                label2.setText(".");
                labelTit2.setText("Department ID:");
                label3.setVisible(true);
                label3.setText(".");
                labelTit3.setText("Vendor Name:");
                label4.setVisible(true);
                label4.setText(".");
                labelTit4.setText("Vendor Phone:");
                label5.setVisible(false);
                label5.setText(".");
                labelTit5.setVisible(false);
                label6.setVisible(false);
                label6.setText(".");
                labelTit6.setVisible(false);
                label7.setVisible(false);
                label7.setText(".");
                labelTit7.setVisible(false);
                label8.setVisible(false);
                label8.setText(".");
                labelTit8.setVisible(false);
                break;
            }
            case "Receipts": // receiptID, deptname, deptmanagerID, amount, purchDate, delivDate, item_count, vendor_id
            {
                label1.setVisible(true);
                label1.setText(".");
                labelTit1.setText("Receipt Id:");
                label2.setVisible(true);
                label2.setText(".");
                labelTit2.setText("Department Id:");
                label3.setVisible(true);
                label3.setText(".");
                labelTit3.setText("Department Manager ID:");
                label4.setVisible(true);
                label4.setText(".");
                labelTit4.setText("Receipt Amount:");
                label5.setVisible(true);
                label5.setText(".");
                labelTit5.setText("Purchase Date:");
                label6.setVisible(true);
                label6.setText(".");
                labelTit6.setText("Delivery Date:");
                label7.setVisible(true);
                label7.setText(".");
                labelTit7.setText("Item Count:");
                label8.setVisible(true);
                label8.setText(".");
                labelTit8.setText("Vendor Id:");
                break;
            }
            case "Meat":        // id, managerid, emp_count, lastInspect
            case "Deli":        // id, managerId, emp_count, last_inspectDate
            case "Seafood":     // id, managerID, empCount, last_inspection
            case "Produce":     // id, manager_id, empCount, lastInspect
            case "Dairy":       // ID, manager_id, empCount, LastInspect
            case "Frozen":      // ID, manager_id, empCount, lastInspect
            {
                label1.setVisible(true);
                label1.setText(".");
                labelTit1.setText("Manager ID:");
                label2.setVisible(true);
                label2.setText(".");
                labelTit2.setText("Employee Count:");
                label3.setVisible(true);
                label3.setText(".");
                labelTit3.setText("Last Inspection:");
                label4.setVisible(false);
                label4.setText(".");
                labelTit4.setVisible(false);
                label5.setVisible(false);
                label5.setText(".");
                labelTit5.setVisible(false);
                label6.setVisible(false);
                label6.setText(".");
                labelTit6.setVisible(false);
                label7.setVisible(false);
                label7.setText(".");
                labelTit7.setVisible(false);
                label8.setVisible(false);
                label8.setText(".");
                labelTit8.setVisible(false);
                break;
            }
            case "Grocery":      // id, managerID, empCount
            {
                label1.setVisible(true);
                label1.setText(".");
                labelTit1.setText("Manager ID:");
                label2.setVisible(true);
                label2.setText(".");
                labelTit2.setText("Employee Count:");
                label3.setVisible(false);
                label3.setText(".");
                labelTit3.setVisible(false);
                label4.setVisible(false);
                label4.setText(".");
                labelTit4.setVisible(false);
                label5.setVisible(false);
                label5.setText(".");
                labelTit5.setVisible(false);
                label6.setVisible(false);
                label6.setText(".");
                labelTit6.setVisible(false);
                label7.setVisible(false);
                label7.setText(".");
                labelTit7.setVisible(false);
                label8.setVisible(false);
                label8.setText(".");
                labelTit8.setVisible(false);
                break;
            }
            case "Managers":     // managerID, empID
            {
                label1.setVisible(true);
                label1.setText(".");
                labelTit1.setText("Manager ID:");
                label2.setVisible(true);
                label2.setText(".");
                labelTit2.setText("Employee ID:");
                label3.setVisible(false);
                label3.setText(".");
                labelTit3.setVisible(false);
                label4.setVisible(false);
                label4.setText(".");
                labelTit4.setVisible(false);
                label5.setVisible(false);
                label5.setText(".");
                labelTit5.setVisible(false);
                label6.setVisible(false);
                label6.setText(".");
                labelTit6.setVisible(false);
                label7.setVisible(false);
                label7.setText(".");
                labelTit7.setVisible(false);
                label8.setVisible(false);
                label8.setText(".");
                labelTit8.setVisible(false);
                break;
            }
            case "Employees":    // empID, empName, empPhone, empStartDate, empEndDate, empTitle, deptID, empDOB, managerID
            {
                label1.setVisible(true);
                label1.setText(".");
                labelTit1.setText("Employee Name:");
                label2.setVisible(true);
                label2.setText(".");
                labelTit2.setText("Employee Phone #:");
                label3.setVisible(true);
                label3.setText(".");
                labelTit3.setText("Start Date:");
                label4.setVisible(true);
                label4.setText(".");
                labelTit4.setText("End Date:");
                label5.setVisible(true);
                label5.setText(".");
                labelTit5.setText("Employee Title:");
                label6.setVisible(true);
                label6.setText(".");
                labelTit6.setText("Department ID:");
                label7.setVisible(true);
                label7.setText(".");
                labelTit7.setText("Date of Birth:");
                label8.setVisible(true);
                label8.setText(".");
                labelTit8.setText("Manager ID:");
                break;
            }
        }
    }

    private void getInfo(int id_val)
    {
        // con = getRemoteConnection();
        //PreparedStatement pst;
        //ResultSet rs;
        switch(table_name)
        {

            case "Items":   // itemID, name, count, exp, dept, veg, age?
            {
                try {
                    String updateSQL = "select * from " + table_name + " WHERE id = " + id_val + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    rs.next();
                    label1.setText(rs.getString("item_name"));
                    label2.setText(Integer.toString(rs.getInt("count")));
                    label3.setText(rs.getDate("exp_date") + "");
                    label4.setText(Integer.toString(rs.getInt("department_id")));
                    label5.setText(Integer.toString(rs.getInt("vegan")));
                    label6.setText(Integer.toString(rs.getInt("age_restricted")));


                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Vendors": // vendorID, comp name, deptid, vendor_name, phone, vendorscol
            {
                try {
                    String updateSQL = "select * from " + table_name + " WHERE vendor_id = " + id_val + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    rs.next();
                    label1.setText(rs.getString("company_name"));
                    label2.setText(Integer.toString(rs.getInt("department_id")));
                    label3.setText(rs.getString("vendor_name"));
                    label4.setText(Integer.toString(rs.getInt("vendor_phone")));
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Receipts": // receiptID, deptname, deptmanagerID, amount, purchDate, delivDate, item_count, vendor_id
            {
                try {
                    String updateSQL = "select * from " + table_name + " WHERE receipt_id = " + id_val + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    rs.next();
                    label1.setText(Integer.toString(rs.getInt("receipt_id")));
                    label2.setText(Integer.toString(rs.getInt("department_id")));
                    label3.setText(Integer.toString(rs.getInt("department_manager_id")));
                    label4.setText("$" + rs.getDouble("amount"));
                    label5.setText(rs.getDate("purchase_date") + "");
                    label6.setText(rs.getDate("delivery_date") + "");
                    label7.setText(Integer.toString(rs.getInt("item_count")));
                    label8.setText(Integer.toString(rs.getInt("vendor_id")));


                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Deli":        // id, managerId, emp_count, last_inspectDate
            case "Produce":     // id, manager_id, empCount, lastInspect
            case "Dairy":       // ID, manager_id, empCount, LastInspect
            case "Meat":        // id, managerID, empCount, lastInspect
            case "Seafood":     // id, managerID, empCount, last_inspection
            case "Frozen":      // ID, manager_id, empCount, lastInspect
            {
                try {
                    String updateSQL = "select * from " + table_name + " WHERE id = " + id_val + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    rs.next();
                    label1.setText(Integer.toString(rs.getInt("manager_id")));
                    label2.setText(Integer.toString(rs.getInt("employee_count")));
                    label3.setText(rs.getDate("last_inspection")+"");


                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Grocery":      // id, managerID, empCount
            {
                try {
                    String updateSQL = "select * from " + table_name + " WHERE id = " + id_val + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    rs.next();
                    label1.setText(Integer.toString(rs.getInt("manager_id")));
                    label2.setText(Integer.toString(rs.getInt("employee_count")));


                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Managers":     // managerID, empID
            {
                try {
                    String updateSQL = "select * from " + table_name + "WHERE manager_id = " + id_val + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    rs.next();
                    label1.setText(Integer.toString(rs.getInt("employee_id")));


                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Employees":    // empID, empName, empPhone, empStartDate, empEndDate, empTitle, deptID, empDOB, managerID
            {
                try {
                    String updateSQL = "select * from " + table_name + " WHERE employee_id = " + id_val + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    rs.next();
                    label1.setText(rs.getString("employee_name"));
                    label2.setText(Integer.toString(rs.getInt("employee_phone")));
                    label3.setText(rs.getDate("employee_startdate")+"");
                    label4.setText(rs.getDate("employee_enddate")+"");
                    label5.setText(rs.getString("employee_title"));
                    label6.setText(Integer.toString(rs.getInt("department_id")));
                    label7.setText(rs.getDate("employee_DOB")+"");
                    label8.setText(Integer.toString(rs.getInt("manager_id")));


                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }

        }

    }

    //update combobox with ID's from the desired table.
    private void refreshItemsFromDB() {
        // con = getRemoteConnection();
        PreparedStatement pst;
        ResultSet rs;
        //JComboBox comboBox = null;
        switch (table_name) {
            case "Items":   // itemID, name, count, exp, dept, veg, age?
            case "Deli":        // id, managerId, emp_count, last_inspectDate
            case "Seafood":     // id, managerID, empCount, last_inspection
            case "Grocery":      // id, managerID, empCount
            case "Produce":     // id, manager_id, empCount, lastInspect
            case "Frozen":      // ID, manager_id, empCount, lastInspect
            case "Meat":        // id, managerId, empCount,Last inspect
            case "Dairy":       // ID, manager_id, empCount, LastInspect
            {
                try {
                    String updateSQL = "select ID from " + table_name;
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    while (rs.next())
                    {
                        comboBox.addItem(rs.getString("id"));
                    }
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Vendors": // vendorID, comp name, deptid, vendor_name, phone, vendorscol
                try {
                    String updateSQL = "select vendor_id from " + table_name + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    while (rs.next())
                    {
                        comboBox.addItem(rs.getString("vendor_id"));
                    }
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            case "Receipts": // receiptID, deptname, deptmanagerID, amount, purchDate, delivDate, item_count, vendor_id
            {
                try {
                    String updateSQL = "select receipt_id from " + table_name + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    while (rs.next())
                    {
                        comboBox.addItem(rs.getString("receipt_id"));
                    }
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Managers":     // managerID, empID
            {
                try {
                    String updateSQL = "select manager_id from " + table_name + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    while (rs.next())
                    {
                        comboBox.addItem(rs.getString("manager_id"));
                    }
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
            case "Employees":    // empID, empName, empPhone, empStartDate, empEndDate, empTitle, deptID, empDOB, managerID
            {
                try {
                    String updateSQL = "select employee_id from " + table_name + ";";
                    con.createStatement();
                    pst = con.prepareStatement(updateSQL);
                    rs = pst.executeQuery();
                    while (rs.next())
                    {
                        comboBox.addItem(rs.getString("employee_id"));
                    }
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
            }
        }
    }

    // RDBS Connection Method
   /* private static Connection getRemoteConnection() {
        try
        {
            //System.out.println("incatch");
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("catcdsfasdfh");
            String url = "jdbc:mysql://cs3630-final-project.cyeihvdlgp54.us-east-2.rds.amazonaws.com/?user=loneye";
            String uname = "loneye";
            String pass = "El110896CUHK$";

            con = DriverManager.getConnection(url, uname, pass);
            System.out.println("connection made!");
            PreparedStatement ps = con.prepareStatement("use mydb;");
            int count = ps.executeUpdate();
            return con;
        }
        catch (ClassNotFoundException e) {System.out.println("classnotfound");}
        catch (SQLException e) {System.out.println("sqlexception");}
        System.out.println("catch");
        return con;
    */}

