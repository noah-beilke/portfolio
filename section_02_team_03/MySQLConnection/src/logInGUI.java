

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.sql.*;

public class logInGUI {
    private JPasswordField passInputBox;
    private JTextField userInputBox;
    private JComboBox jobTypeDropDown;
    private JButton logInButton;
    private JPanel loginPanel;
    private static JFrame frame;
    private static Connection con;
    private String getType;
    private updateGUI updategui;
    private String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private String uname = "root";

    public String getUrl() {
        return url;
    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }

    private String pass = "password";
    public logInGUI() {

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuGUI mainmenu = new mainMenuGUI();
                con = getRemoteConnection();
                getType = jobTypeDropDown.getSelectedItem().toString();
                mainmenu.startUpdate(frame, con, getType);
            }
        });
    }

    //private updateGUI updategui;
    private Connection getRemoteConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
                String uname = userInputBox.getText();
                String pass = passInputBox.getText();
                Connection conn;
                conn = DriverManager.getConnection(url, uname, pass);
                PreparedStatement ps = conn.prepareStatement("use mydb;");
                int count = ps.executeUpdate();
                return conn;
            }
            catch (ClassNotFoundException e) {}
            catch (SQLException e) {}
            return null;
    }

    public void startUp()
    {
        frame = new JFrame("Login");
        frame.setContentPane(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception
    {
        logInGUI loginGUI = new logInGUI();
        loginGUI.startUp();
        // String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        //String uname = "root";
        //String pass = "password";
        //Connection conn1 = DriverManager.getConnection(url, uname, pass);
        //PreparedStatement ps = conn1.prepareStatement("use mydb;");

        //Class.forName("com.mysql.jdbc.Driver");
        //String dbName = System.getenv("section_02_team_03");
        // String dbName = "section_02_team_03";
        //String userName = System.getenv("loneye");
        //String userName = "admin";
        //String password = System.getenv("El110896CUHK$");
        //String password = "admin1234";
        //String hostname = System.getenv("cs3630-final-project.cyeihvdlgp54.us-east-2.rds.amazonaws.com");
        //String hostname = "jdbc:mysql://test.cyeihvdlgp54.us-east-2.rds.amazonaws.com:3306";
        //String port = System.getenv("3306");
        //String port = "3306";
        // String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
        //logger.trace("Getting remote connection with connection string from environment variables.");
        //Connection con = DriverManager.getConnection(jdbcUrl);
        // Connection conn = DriverManager.getConnection(hostname, userName, password);
        //System.out.println("here");
        //logger.info("Remote connection successful.");
        //int count = ps.executeUpdate();
        //ps = conn.prepareStatement("INSERT INTO vendors(vendor_id, company_name, department_id, vendor_name, vendor_phone) VALUES (1, 'Company Name Here', 1, 'Name Here', 4440000);");
        //count = ps.executeUpdate();
        //Statement st = conn.createStatement();
        //ResultSet rs = st.executeQuery("SELECT * FROM vendors");
    }
}
