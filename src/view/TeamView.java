package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.Model;
import model.MyTableModel;

public class TeamView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -3615263799621093916L;
    private JPanel contentPane;
    private JTable teamTable;
    private JButton btnAddTeam;
    private JButton btnDeleteTeam;
    private static int TEAM_TABLE = 2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TeamView frame = new TeamView();
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
    private TeamView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        teamTable = new JTable();
        teamTable.setBounds(108, 131, 492, 245);
        contentPane.add(teamTable);
        
        btnAddTeam = new JButton("Add Team");
        btnAddTeam.setBounds(133, 415, 179, 29);
        contentPane.add(btnAddTeam);
        
        btnDeleteTeam = new JButton("Delete Team");
        btnDeleteTeam.setBounds(388, 415, 179, 29);
        contentPane.add(btnDeleteTeam);
        
        JLabel lblTeamName = new JLabel("TEAM NAME");
        lblTeamName.setBounds(173, 103, 82, 16);
        contentPane.add(lblTeamName);
        
        JLabel lblCompany = new JLabel("COMPANY");
        lblCompany.setBounds(436, 103, 69, 16);
        contentPane.add(lblCompany);
    }
    
    public TeamView(final Model model){
        this();
        teamTable.setModel(new MyTableModel(model));
        btnAddTeam.addActionListener(e->{
           AddTeam t = new AddTeam();
          // t.attachObserver(new TeamController(model));
           t.repaint();
           t.setVisible(true);
        });
        
        btnDeleteTeam.addActionListener(e->{
            
        });
    }
}
