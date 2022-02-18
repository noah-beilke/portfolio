import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Locale;

public class updateGUI {
    private JComboBox itemIDbox;
    private JButton updateButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    private JTextField inputID;
    private JButton Select;
    private JPanel updatePanel;
    private JTextField textField4;
    private JTextField textField9;
    private JTextField textField5;
    private JTextField textField10;
    private JLabel label4;
    private JLabel label5;
    private JLabel label10;
    private JLabel label9;
    private JLabel label3;
    private JLabel label2;
    private JLabel label1;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel selectItemIDLabel;
    private JLabel notUpdatalbeLabel;
    private JButton mainMenuButton;
    private static JFrame frame;
    private boolean flag = true;
    private int itemID;
    private String id;
    private static Connection conn;
    private PreparedStatement ps;
    private static String table;
    private boolean check = false;
    private boolean manager = false;


    public void startUpdate(String tableName, JFrame mFrame, Connection connection, Boolean isManager) {
        frame = mFrame;
        frame.setContentPane(updatePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        table = tableName;
        check = true;
        conn = connection;
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        textField4.setVisible(false);
        textField5.setVisible(false);
        textField6.setVisible(false);
        textField7.setVisible(false);
        textField8.setVisible(false);
        textField9.setVisible(false);
        textField10.setVisible(false);
        notUpdatalbeLabel.setVisible(false);
        manager = isManager;

        if (table.equals("Items")) {
            textField1.setVisible(true);
            textField2.setVisible(true);
            textField3.setVisible(true);
            textField6.setVisible(true);
            textField7.setVisible(true);
            textField8.setVisible(true);
            label1.setText("Item Name:");
            label2.setText("Count:");
            label3.setText("Expiration Date:");

            label6.setText("Department ID:");
            label7.setText("Vegan?:");
            label8.setText("Age Restriction?:");
        }
        else if(table.equals("Vendors"))
        {
            textField1.setVisible(true);
            textField2.setVisible(true);
            textField3.setVisible(true);
            textField6.setVisible(true);
            //textField7.setVisible(true);

            label1.setText("Company Name:");
            label2.setText("Department ID:");
            label3.setText("Vendor Name:");

            label6.setText("Vendor Phone:");
            //label7.setText("Vendorscol:");
        }
        else if(table.equals("Receipts"))
        {
            textField1.setVisible(true);
            textField2.setVisible(true);
            textField3.setVisible(true);
            textField4.setVisible(true);
            textField6.setVisible(true);
            textField7.setVisible(true);
            textField8.setVisible(true);

            label1.setText("Dpeartment ID:");
            label2.setText("Department Manager ID:");
            label3.setText("Amount:");
            label4.setText("Purchase Date:");

            label6.setText("Delivery Date:");
            label7.setText("Item Count:");
            label8.setText("Vendor ID:");
        }
        else if (table.equals("Employees") && manager == true)
        {
            textField1.setVisible(true);
            textField2.setVisible(true);
            textField3.setVisible(true);
            textField4.setVisible(true);

            textField6.setVisible(true);
            textField7.setVisible(true);
            textField8.setVisible(true);
            textField9.setVisible(true);

            label1.setText("Employee Name:");
            label2.setText("Employee Phone:");
            label3.setText("Employee Start Date:");
            label4.setText("Employee End Date:");

            label6.setText("Employee Title:");
            label7.setText("Department ID:");
            label8.setText("Employee Date Of Birth:");
            label9.setText("Manager ID:");
        }
        else //not updatable
        {
            //show a label that states that nothing is updatable
            selectItemIDLabel.setVisible(false);
            // itemIDbox.setVisible(false);
            updateButton.setVisible(false);
            Select.setVisible(false);
            inputID.setVisible(false);
            notUpdatalbeLabel.setVisible(true);

        }

    }
    public updateGUI()
    {


        //not done and not tested
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (table.equals("Items")) {
                        String item_name = textField1.getText();
                        String count = textField2.getText();
                        String exp_date = textField3.getText();
                        String department_id = textField6.getText();
                        String isVegan = textField7.getText();
                        if(isVegan == null)
                        {

                        }
                        else if(isVegan.equalsIgnoreCase("y"))
                        {
                            isVegan = "1";
                        }
                        else if(isVegan.equalsIgnoreCase("n"))
                        {

                        }
                        String age_restricted = textField8.getText();
                        if(age_restricted.toLowerCase().equals("y"))
                        {
                            age_restricted = "1";
                        }
                        else if(age_restricted.toLowerCase().equals("n"))
                        {
                            age_restricted = "0";
                        }
                        String command = "UPDATE items SET item_name = '" + item_name + "' , count = " + count +
                                ", exp_date = '" + exp_date + "', department_id = " + department_id;
                        if(isVegan == null)
                        {
                            command+= ", age_restricted = " + age_restricted + " WHERE id = " + id + " ;";
                        }
                        else if(isVegan.equalsIgnoreCase("n"))
                        {
                            command += ", vegan = " + null +
                                    ", age_restricted = " + age_restricted + " WHERE id = " + id + " ;";
                        }
                        else
                        {
                            command += ", vegan = " + isVegan +
                                    ", age_restricted = " + age_restricted + " WHERE id = " + id + " ;";
                        }
                        ps = conn.prepareStatement(command);
                        System.out.println(command);
                        int lcv = ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Database Updated.", "Updated", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(table.equals("Vendors"))
                    {
                        String vendorID = inputID.getText();
                        String companyName =  textField1.getText();
                        String departmentID = textField2.getText();
                        String vendorName =  textField3.getText();
                        String vendorPhone =  textField6.getText();
                        //String vendorscol =  textField7.getText();

                        ps = conn.prepareStatement("UPDATE vendors SET " +
                                "company_name = '"+companyName+"', "+
                                "department_id = "+departmentID+", "+
                                "vendor_name = '"+vendorName+"', "+
                                "vendor_phone = "+vendorPhone+" "+
                                "WHERE vendor_id = "+vendorID+";");
                        System.out.println("UPDATE vendors SET   " +
                                "company_name = '"+companyName+"', "+
                                "department_id = "+departmentID+", "+
                                "vendor_name = '"+vendorName+"', "+
                                "vendor_phone = "+vendorPhone+" "+
                                "WHERE vendor_id = "+vendorID+";");
                        int lcv = ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Database Updated.", "Updated", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(table.equals("Receipts"))
                    {
                        String receiptID = inputID.getText();
                        String departmentID =  textField1.getText();
                        String departmentManagerID = textField2.getText();
                        String amount =  textField3.getText();
                        String purchaseDate =  textField4.getText();
                        String deliveryDate =  textField6.getText();
                        String itemCount =  textField7.getText();
                        String vendorID =  textField8.getText();

                        ps = conn.prepareStatement("UPDATE receipts SET   " +
                                "receipt_id = "+receiptID+", "+
                                "department_ID = "+departmentID+", "+
                                "department_manager_id = "+departmentManagerID+", "+
                                "amount = "+amount+", "+
                                "purchase_date = '"+purchaseDate+"', "+
                                "delivery_date = '"+deliveryDate+"', "+
                                "item_count = "+itemCount+", "+
                                "vendor_id = "+vendorID+" "+
                                "WHERE receipt_id = "+receiptID+";");
                        System.out.println("UPDATE receipts SET   " +
                                "department_id = "+departmentID+", "+
                                "department_manager_id = "+departmentManagerID+", "+
                                "amount = "+amount+", "+
                                "purchase_date = '"+purchaseDate+"', "+
                                "delivery_date = '"+deliveryDate+"', "+
                                "item_count = "+itemCount+", "+
                                "vendor_id = "+deliveryDate+" "+
                                "WHERE receipt_id = "+vendorID+";");
                        int lcv = ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Database Updated.", "Updated", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (table.equals("Employees") && manager)
                    {
                        String employee_id = inputID.getText();
                        String employee_name =  textField1.getText();
                        String employee_phone = textField2.getText();
                        String employee_startdate =  textField3.getText();
                        String employee_enddate =  textField4.getText();
                        String employee_title =  textField6.getText();
                        String department_id =  textField7.getText();
                        String employee_DOB =  textField8.getText();
                        String manager_id =  textField9.getText();
                        if(manager_id.equals(""))
                        {
                            manager_id = null;
                        }
                        if(employee_enddate.equals(""))
                        {
                            employee_enddate =null;
                        }
                        String cmd = "UPDATE employees SET   " +
                                "employee_name = '"+employee_name+"', "+
                                "employee_phone = "+employee_phone+", "+
                                "employee_startdate = '"+employee_startdate+"', "+
                                "employee_DOB = '"+employee_DOB+"', "+
                                "employee_title = '"+employee_title+"', "+
                                "department_id = "+department_id+" ";
                        if(manager_id!=null)
                        {
                            cmd += ", manager_id = "+manager_id+" ";
                        }
                        if(employee_enddate!=null)
                        {
                            cmd += ",employee_enddate = '"+employee_enddate+"' ";
                        }
                        else
                        {
                            cmd += ",employee_enddate = NULL ";
                        }
                        ps = conn.prepareStatement(cmd+
                                " WHERE employee_id = "+employee_id+";");

                        int lcv = ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Database Updated.", "Updated", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else //not updatable
                    {
                        JOptionPane.showMessageDialog(null, "Invalid ID.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }


        });
        //select is done but not tested
        Select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputID.getText().equals("")) {
                    try {
                        if (table.equals("Items"))
                        {

                            itemID = Integer.parseInt(inputID.getText());
                            Statement st = conn.createStatement();

                            ResultSet rs = st.executeQuery("SELECT * FROM items WHERE id =" + itemID);

                            while (rs.next()) {
                                id = rs.getString("id");
                                String item_name = rs.getString("item_name");
                                String count = rs.getString("count");
                                String exp_date = rs.getString("exp_date");
                                String department_id = rs.getString("department_id");
                                String isVegan = rs.getString("vegan");
                                String age_restricted = rs.getString("age_restricted");
                                if(isVegan == null)
                                {
                                    isVegan = "N";
                                }
                                else
                                {
                                    isVegan = "Y";
                                }
                                if(age_restricted.equalsIgnoreCase("1"))
                                {
                                    age_restricted = "Y";
                                }
                                else
                                {
                                    age_restricted = "N";
                                }
                                textField1.setText(item_name);
                                textField2.setText(count);
                                textField3.setText(exp_date);
                                textField6.setText(department_id);
                                textField7.setText(isVegan);
                                textField8.setText(age_restricted);
                            }
                        }
                        else if(table.equals("Vendors"))
                        {
                            itemID = Integer.parseInt(inputID.getText());
                            Statement st = conn.createStatement();

                            ResultSet rs = st.executeQuery("SELECT * FROM vendors WHERE vendor_id = " + itemID);
                            while (rs.next()) {
                                id = rs.getString("vendor_id");
                                String companyName = rs.getString("company_name");
                                String department_id = rs.getString("department_id");
                                String vendorName = rs.getString("vendor_name");
                                String vendorPhone = rs.getString("vendor_phone");
                                //String vendorscol = rs.getString("Vendorscol");
                                textField1.setText(companyName);
                                textField2.setText(department_id);
                                textField3.setText(vendorName);
                                textField6.setText(vendorPhone);
                                //textField7.setText(vendorscol);
                            }
                        }
                        else if(table.equals("Receipts"))
                        {
                            itemID = Integer.parseInt(inputID.getText());
                            Statement st = conn.createStatement();

                            ResultSet rs = st.executeQuery("SELECT * FROM receipts WHERE receipt_id = " + itemID);
                            while (rs.next()) {
                                id = rs.getString("receipt_id");
                                String department_id = rs.getString("department_id");
                                String departmentManagerID = rs.getString("department_manager_id");
                                String amount = rs.getString("amount");
                                String purchaseDate = rs.getString("purchase_date");
                                String deliveryDate = rs.getString("delivery_date");
                                String itemCount = rs.getString("item_count");
                                String vendorID = rs.getString("vendor_id");
                                textField1.setText(department_id);
                                textField2.setText(departmentManagerID);
                                textField3.setText(amount);
                                textField4.setText(purchaseDate);
                                textField6.setText(deliveryDate);
                                textField7.setText(itemCount);
                                textField8.setText(vendorID);
                            }
                        }
                        else if (table.equals("Employees") && manager)
                        {
                            itemID = Integer.parseInt(inputID.getText());
                            Statement st = conn.createStatement();

                            ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE employee_id =" + itemID);
                            while (rs.next()) {
                                id = rs.getString("employee_id");
                                String employeeName = rs.getString("employee_name");
                                String employeePhone = rs.getString("employee_phone");
                                String employeeStartDate = rs.getString("employee_startdate");
                                String employeeEndDate = rs.getString("employee_enddate");
                                String employeeTitle = rs.getString("employee_title");
                                String department_id = rs.getString("department_id");
                                String employeeDOB = rs.getString("employee_DOB");
                                String managerID = rs.getString("manager_id");
                                textField1.setText(employeeName);
                                textField2.setText(employeePhone);
                                textField3.setText(employeeStartDate);
                                textField4.setText(employeeEndDate);
                                textField6.setText(employeeTitle);
                                textField7.setText(department_id);
                                textField8.setText(employeeDOB);
                                textField9.setText(managerID);

                            }
                        }
                        else //not updatable
                        {

                        }

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    System.out.println("Empty");
                }
            }
        });
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuGUI mainmenuGUI = new mainMenuGUI();
                String type;
                if (manager == true)
                {
                    type = "Manager";
                }
                else {
                    type = "Employee";
                }
                mainmenuGUI.startUpdate(frame,conn,type);

            }
        });
    }


}
