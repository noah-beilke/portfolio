import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class mainMenuGUI {
    private JComboBox tableComboBox;
    private JButton addEntryButton;
    private JButton removeEntryButton;
    private JButton selectEntryButton;
    private JButton updateEntryButton;
    private JPanel mainPanel;
    private String table;
    private String getType;
    private static Connection con;
    private static JFrame frame;

    public mainMenuGUI() {
        addEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table = (String)tableComboBox.getSelectedItem();
                System.out.println(table);
                itemAddGUI insertMenu = new itemAddGUI();
                insertMenu.startInsert(table, frame, con, getType);
            }
        });
        removeEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table = (String)tableComboBox.getSelectedItem();
                System.out.println(table);
                deleteUI insertMenu = new deleteUI();
                insertMenu.startDelete(table, frame, con, getType);
            }
        });
        selectEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table = (String)tableComboBox.getSelectedItem();
                System.out.println(table);
                selectGUI selectMenu = new selectGUI();
                selectMenu.startSelect(table, frame, con, getType);
            }
        });
        updateEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table = (String)tableComboBox.getSelectedItem();
                updateGUI updategui = new updateGUI();
                if(getType == "Employee")
                {
                    updategui.startUpdate(table, frame, con, false);
                }
                else
                {
                    updategui.startUpdate(table, frame, con, true);
                }


            }
        });
    }

    public void startUpdate(JFrame nframe, Connection conIn, String type) {
        frame = nframe;
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        con = conIn;
        getType = type;
        updatePanel();
    }
    public void returnMenu(JFrame nframe, Connection conIn) {
        frame = nframe;
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        con = conIn;
        updatePanel();
    }
    private void updatePanel()
    {
        if(getType == "Employee")
        {
            addEntryButton.setEnabled(false);
            removeEntryButton.setEnabled(false);
        }
        else
        {
            addEntryButton.setEnabled(true);
            removeEntryButton.setEnabled(true);
        }
    }
}
