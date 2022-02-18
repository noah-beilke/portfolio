import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.event.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class deleteUI {
    private JComboBox deleteIDcomboBox;
    private JButton deleteButton;
    private JLabel deleteNameLabel;
    private JPanel deletePanel;
    private JButton mainMenuButton;
    private JLabel itemToDeleteLabel;
    private JLabel selectDepartmentLabel;
    private JLabel selectIDLabel;
    private JComboBox departmentComboBox;
    private JFrame frame;
    private boolean flag = true;
    private static JFrame deleteFrame;
    private static Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String selectedDepartment = null;
    private String id_format = null;
    private String id_to_delete = null;
    private String getType;

    public void startDelete(String tableName, JFrame nframe, Connection conIn, String typeIn)
    {
        deleteFrame = nframe;
        deleteFrame.setContentPane(deletePanel);
        deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteFrame.getContentPane().setEnabled(true);
        deleteFrame.getContentPane().setVisible(true);
        deleteFrame.pack();
        deleteFrame.getContentPane().revalidate();
        deleteFrame.getContentPane().repaint();
        con = conIn;
        getType = typeIn;
    }

    public deleteUI() {
        // Return to main menu button functionality
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuGUI mainMenu = new mainMenuGUI();
                mainMenu.startUpdate(deleteFrame, con,getType);
            }
        });

        // Generate the available item ID's to delete
        departmentComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //con = getRemoteConnection();
                try {
                    selectedDepartment = departmentComboBox.getSelectedItem().toString();
                    switch(selectedDepartment) {
                        case "Items": {
                            id_format = "id";
                            deleteButton.setText("Delete");
                            itemToDeleteLabel.setText("Item to delete: ");
                            selectIDLabel.setText("Select Item ID to delete:");
                            break;
                        }
                        case "Vendors": {
                            id_format = "vendor_id";
                            deleteButton.setText("Remove");
                            itemToDeleteLabel.setText("Vendor to remove: ");
                            selectIDLabel.setText("Select Vendor ID to remove:");
                            break;
                        }
                        case "Recepits": {
                            id_format = "receipt_id";
                            deleteButton.setText("Delete");
                            itemToDeleteLabel.setText("Recepit to delete: ");
                            selectIDLabel.setText("Select Recepit ID to delete:");
                            break;
                        }
                        case "Employees": {
                            id_format = "employee_id";
                            deleteButton.setText("Fire");
                            itemToDeleteLabel.setText("Employee to Fire: ");
                            selectIDLabel.setText("Select Employee ID to Fire:");
                            break;
                        }
                    }
                    // Pouplate with new stuff...
                    departmentComboBox.updateUI();
                    deleteIDcomboBox.removeAllItems();
                    String updateSQL = "SELECT " + id_format + " FROM "
                            + selectedDepartment + " ORDER BY " + id_format + " ASC;";
                    // Checking if employee_enddate set
                    if(selectedDepartment == "Employees") {
                        updateSQL = "SELECT " + id_format + " FROM Employees " +
                                "WHERE employee_enddate IS NULL ORDER BY employee_enddate ASC;";
                    }
                    System.out.println(updateSQL);
                    con.createStatement();
                    ps = con.prepareStatement(updateSQL);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        deleteIDcomboBox.addItem(rs.getString(id_format));
                        //System.out.println("added entry!");
                    }
                }
                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                    //System.out.println("adding issue...");
                }
            }
        });

        // Update selected id number text field
        deleteIDcomboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(deleteIDcomboBox.getSelectedItem() != null) {
                    id_to_delete = deleteIDcomboBox.getSelectedItem().toString();
                    deleteNameLabel.setText(id_to_delete);
                }
            }
        });

        // Delete Button Functionality
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                try {
                    //con = getRemoteConnection();
                    String updateSQL = "DELETE FROM " + selectedDepartment +
                            " WHERE " + id_format + "=" + id_to_delete + ";";
                    if(selectedDepartment == "Employees") {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDateTime now = LocalDateTime.now();
                        //System.out.println(dtf.format(now));
                        String end_date = dtf.format(now);
                        //System.out.println(end_date);
                        JOptionPane.showMessageDialog(null,"Employee " + id_to_delete + " has been fired!","Employee Termination Results" , JOptionPane.INFORMATION_MESSAGE);
                        updateSQL = " UPDATE Employees SET employee_enddate = '"
                                + end_date + "' WHERE employee_id = " + id_to_delete + ";";
                    }
                    System.out.println(updateSQL);
                    con.createStatement();
                    ps = con.prepareStatement(updateSQL);
                    ps.executeUpdate();
                    // Update comboboxes
                    departmentComboBox.updateUI();
                    deleteIDcomboBox.removeItem(id_to_delete);
                }
                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                    //System.out.println("deleting issue...");
                }
            }
        });
    }

    /*
    // RDBS Connection Method
    private static Connection getRemoteConnection() {
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
    }*/
}
