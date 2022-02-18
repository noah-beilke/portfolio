import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.*;

public class itemAddGUI {
    private JLabel tableLabel;
    private JTextField textBox1;
    private JTextField textBox7;
    private JTextField textBox8;
    private JTextField textBox9;
    private JCheckBox veganCheckBox;
    private JCheckBox ageRestrictedCheckBox;
    private JButton addButton;
    private JTextField textBox2;
    private JTextField textBox3;
    private JTextField textBox4;
    private JTextField textBox5;
    private JTextField textBox6;
    private JButton menuButton;
    private String table_name;
    private JPanel insertPanel;
    private static JFrame insertFrame;
    private static Connection con;
    private PreparedStatement ps;
    private String getType;

    public void startInsert(String tableName, JFrame nframe, Connection conIn, String typeIn)
    {
        insertFrame = nframe;
        insertFrame.setContentPane(insertPanel);
        insertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insertFrame.getContentPane().setEnabled(true);
        insertFrame.getContentPane().setVisible(true);
        insertFrame.pack();
        insertFrame.getContentPane().revalidate();
        insertFrame.getContentPane().repaint();
        tableLabel.setText(tableName);
        table_name = tableName;
        con = conIn;
        getType = typeIn;
        this.load();
    }
    public itemAddGUI() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = "INSERT INTO " + table_name + "(";
                switch(table_name)
                {
                    //Item and vendor complete, fix rest having string issues
                    case "Items":
                    {
                        cmd = "INSERT INTO items(";
                        cmd += "id, item_name, count, ";
                        if (textBox4.getText().length() > 1)
                        {
                            cmd += "exp_date, ";
                            cmd += "department_id";
                            if (veganCheckBox.isSelected() == true)
                            {
                                cmd += ", vegan";
                                if (ageRestrictedCheckBox.isSelected() == true)
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                                else
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                            }
                            else
                            {
                                if (ageRestrictedCheckBox.isSelected() == true)
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                                else
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                            }
                        }
                        else
                        {
                            cmd += "department_id";
                            if (veganCheckBox.isSelected() == true)
                            {
                                cmd += ", vegan";
                                if (ageRestrictedCheckBox.isSelected() == true)
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                                else
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                            }
                            else
                            {
                                if (ageRestrictedCheckBox.isSelected() == true)
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                                else
                                {
                                    cmd += ", age_restricted";
                                    cmd += ") VALUES (";
                                }
                            }
                        }
                        cmd += textBox1.getText() + ", '" + textBox2.getText() + "', " + textBox3.getText() + ", ";
                        if (textBox4.getText().length() > 1)
                        {
                            cmd += "'" + textBox4.getText() + "', ";
                        }
                        cmd += textBox5.getText();
                        if (veganCheckBox.isSelected() == true)
                        {
                            cmd += ", TRUE";
                            if (ageRestrictedCheckBox.isSelected() == true) {
                                cmd += ", TRUE";
                                cmd += ");";
                            }
                            else
                            {
                                cmd += ", FALSE";
                                cmd += ");";
                            }
                        }
                        else
                        {
                            if (ageRestrictedCheckBox.isSelected() == true)
                            {
                                cmd += ", TRUE";
                                cmd += ");";
                            }
                            else
                            {
                                cmd += ", FALSE";
                                cmd += ");";
                            }
                        }
                        break;
                    }
                    case "Vendors":
                    {
                        cmd += "vendor_id, company_name, department_id, vendor_name";
                        if (textBox5.getText().length() > 1)
                        {
                            cmd += ", vendor_phone) VALUES (";
                        }
                        else
                        {
                            cmd += ") VALUES (";
                        }
                        cmd += textBox1.getText() + ", '" + textBox2.getText() + "', " + textBox3.getText() + ", '" +
                                textBox4.getText() + "'";
                        if (textBox5.getText().length() > 1)
                        {
                            cmd += ", " + textBox5.getText() + ");";
                        }
                        else
                        {
                            cmd += ");";
                        }
                        break;
                    }
                    case "Receipts":
                    {
                        cmd += "receipt_id, department_id, department_manager_id, amount, purchase_date, " +
                                "delivery_date, item_count, vendor_id) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", " + textBox3.getText() + ", " +
                                textBox4.getText() + ", '" + textBox5.getText() + "', '" + textBox6.getText() + "', " +
                                textBox7.getText() + ", " + textBox8.getText() +");";
                        break;
                    }
                    case "Employees":
                    {
                        cmd += "employee_id, employee_name, employee_phone, employee_startdate, ";
                        if (textBox5.getText().length() > 1)
                        {
                            cmd += "employee_enddate, ";
                            cmd += "employee_title, department_id, employee_DOB";
                        }
                        else
                        {
                            cmd += "employee_title, department_id, employee_DOB";
                        }

                        if (textBox9.getText().length() > 1)
                        {
                            cmd += ", manager_id) VALUES (";
                        }
                        else
                        {
                            cmd += ") VALUES (";
                        }
                        cmd += textBox1.getText() + ", '" + textBox2.getText() + "', " + textBox3.getText() + ", '" +
                                textBox4.getText() + "', ";
                        if (textBox5.getText().length() > 1)
                        {
                            cmd += "'" + textBox5.getText() + "', '";
                            cmd += textBox6.getText() + "', " + textBox7.getText() + ", '" + textBox8.getText() + "'";
                        }
                        else
                        {
                            cmd += "'" + textBox6.getText() + "', " + textBox7.getText() + ", '" + textBox8.getText() + "'";
                        }
                        if (textBox9.getText().length() > 1)
                        {
                            cmd += ", " + textBox9.getText() + ");";
                        }
                        else
                        {
                            cmd += ");";
                        }
                        break;
                    }
                    case "Grocery":
                    {
                        cmd += "id, manger_id, employee_count) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", " + textBox3.getText() + ");";
                        break;
                    }
                    case "Liquor":
                    {
                        cmd += "id, manger_id, employee_count) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", " + textBox3.getText() + ");";
                        break;
                    }
                    case "Managers":
                    {
                        cmd += "manager_id, employee_id) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ");";
                        break;
                    }
                    case "Produce":
                    {
                        cmd += "id, manager_id, employee_count, last_inspection) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", "
                                + textBox3.getText() + ", '" + textBox4.getText() + "');";
                        break;
                    }
                    case "Frozen":
                    {
                        cmd += "id, manager_id, employee_count, last_inspection) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", "
                                + textBox3.getText() + ", '" + textBox4.getText() + "');";
                        break;
                    }
                    case "Meat":
                    {
                        cmd += "id, manager_id, employee_count, last_inspection) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", "
                                + textBox3.getText() + ", '" + textBox4.getText() + "');";
                        break;
                    }
                    case "Dairy":
                    {
                        cmd += "id, manager_id, employee_count, last_inspection) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", "
                                + textBox3.getText() + ", '" + textBox4.getText() + "');";
                        break;
                    }
                    case "Deli":
                    {
                        cmd += "id, manager_id, employee_count, last_inspection) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", "
                                + textBox3.getText() + ", '" + textBox4.getText() + "');";
                        break;
                    }
                    case "Seafood":
                    {
                        cmd += "id, manager_id, employee_count, last_inspection) VALUES (";
                        cmd += textBox1.getText() + ", " + textBox2.getText() + ", "
                                + textBox3.getText() + ", '" + textBox4.getText() + "');";
                        break;
                    }
                }
                // Run insert command
                Statement st = null;
                try {
                    st = con.createStatement();
                    PreparedStatement ps = con.prepareStatement(cmd);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Added.", "Added", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuGUI mainMenu = new mainMenuGUI();
                mainMenu.startUpdate(insertFrame, con, getType);
            }
        });
    }
    /*private static Connection getRemoteConnection() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String uname = "root";
            String pass = "Roadranger1969";

            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement ps = con.prepareStatement("use mydb;");
            int count = ps.executeUpdate();
            return con;
        }
        catch (ClassNotFoundException e) {}
        catch (SQLException e) {}
        return con;
    }*/
    private void load()
    {
        switch(table_name)
        {
            case "Items":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Item id");
                textBox2.setEnabled(true);
                textBox2.setText("Item name");
                textBox3.setEnabled(true);
                textBox3.setText("Item count");
                textBox4.setEnabled(true);
                textBox4.setText("Expiration Date");
                textBox5.setEnabled(true);
                textBox5.setText("Department Id");
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(true);
                ageRestrictedCheckBox.setEnabled(true);
                break;
            }
            case "Vendors":
            {
                textBox1.setEnabled(true);
                textBox2.setEnabled(true);
                textBox3.setEnabled(true);
                textBox4.setEnabled(true);
                textBox5.setEnabled(true);
                textBox1.setText("Vendor Id");
                textBox2.setText("Company Name");
                textBox3.setText("Department Id");
                textBox4.setText("Vendor Name");
                textBox5.setText("Vendor Phone");
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Receipts":
            {
                textBox1.setEnabled(true);
                textBox2.setEnabled(true);
                textBox3.setEnabled(true);
                textBox4.setEnabled(true);
                textBox5.setEnabled(true);
                textBox6.setEnabled(true);
                textBox7.setEnabled(true);
                textBox8.setEnabled(true);
                textBox1.setText("Receipt Id");
                textBox2.setText("Department Id");
                textBox3.setText("Department Manager Id");
                textBox4.setText("Amount");
                textBox5.setText("Purchase Date");
                textBox6.setText("Delivery Date");
                textBox7.setText("Item Count");
                textBox8.setText("Vendor Id");
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Employees":
            {
                textBox1.setEnabled(true);
                textBox2.setEnabled(true);
                textBox3.setEnabled(true);
                textBox4.setEnabled(true);
                textBox5.setEnabled(true);
                textBox6.setEnabled(true);
                textBox7.setEnabled(true);
                textBox8.setEnabled(true);
                textBox9.setEnabled(true);
                textBox1.setText("Employee Id");
                textBox2.setText("Employee Name");
                textBox3.setText("Employee Phone");
                textBox4.setText("Employee Start Date");
                textBox5.setText("Employee End Date");
                textBox6.setText("Employee Title");
                textBox7.setText("Department ID");
                textBox8.setText("Employee DOB");
                textBox9.setText("Manager Id");
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Grocery":
            {
                textBox1.setEnabled(true);
                textBox2.setEnabled(true);
                textBox3.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setText("Manager Id");
                textBox3.setText("Employee Count");
                textBox4.setEnabled(false);
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Managers":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Manager Id");
                textBox2.setEnabled(true);
                textBox2.setText("Employee_id");
                textBox3.setEnabled(false);
                textBox4.setEnabled(false);
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Produce":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setEnabled(true);
                textBox2.setText("Manager Id");
                textBox3.setEnabled(true);
                textBox3.setText("Employee_Count");
                textBox4.setEnabled(true);
                textBox4.setText("Last Inspection");
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Frozen":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setEnabled(true);
                textBox2.setText("Manager Id");
                textBox3.setEnabled(true);
                textBox3.setText("Employee_Count");
                textBox4.setEnabled(true);
                textBox4.setText("Last Inspection");
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Meat":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setEnabled(true);
                textBox2.setText("Manager Id");
                textBox3.setEnabled(true);
                textBox3.setText("Employee_Count");
                textBox4.setEnabled(true);
                textBox4.setText("Last Inspection");
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Dairy":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setEnabled(true);
                textBox2.setText("Manager Id");
                textBox3.setEnabled(true);
                textBox3.setText("Employee_Count");
                textBox4.setEnabled(true);
                textBox4.setText("Last Inspection");
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Deli":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setEnabled(true);
                textBox2.setText("Manager Id");
                textBox3.setEnabled(true);
                textBox3.setText("Employee_Count");
                textBox4.setEnabled(true);
                textBox4.setText("Last Inspection");
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Seafood":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setEnabled(true);
                textBox2.setText("Manager Id");
                textBox3.setEnabled(true);
                textBox3.setText("Employee_Count");
                textBox4.setEnabled(true);
                textBox4.setText("Last Inspection");
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
                break;
            }
            case "Liquor":
            {
                textBox1.setEnabled(true);
                textBox1.setText("Id");
                textBox2.setEnabled(true);
                textBox2.setText("Manager Id");
                textBox3.setEnabled(true);
                textBox3.setText("Employee_Count");
                textBox4.setEnabled(false);
                textBox5.setEnabled(false);
                textBox6.setEnabled(false);
                textBox7.setEnabled(false);
                textBox8.setEnabled(false);
                textBox9.setEnabled(false);
                veganCheckBox.setEnabled(false);
                ageRestrictedCheckBox.setEnabled(false);
            }

        }
    }
}