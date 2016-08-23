package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class TeamComponentView extends JFrame {

    private JPanel contentPane;
    private JTable componentsTable;
    private JButton deleteComponent;
    private JButton addComponent;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TeamComponentView frame = new TeamComponentView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TeamComponentView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        componentsTable = new JTable();
        componentsTable.setBounds(108, 131, 492, 245);
        contentPane.add(componentsTable);
        
        addComponent = new JButton("Add Component");
        addComponent.setBounds(133, 415, 179, 29);
        contentPane.add(addComponent);
        
        deleteComponent = new JButton("Delete");
        deleteComponent.setBounds(388, 415, 179, 29);
        contentPane.add(deleteComponent);
        
        JLabel lblTeamName = new JLabel("NAME");
        lblTeamName.setBounds(173, 103, 82, 16);
        contentPane.add(lblTeamName);
        
        JLabel lblCompany = new JLabel("ROLE");
        lblCompany.setBounds(436, 103, 69, 16);
        contentPane.add(lblCompany);
    }
}
