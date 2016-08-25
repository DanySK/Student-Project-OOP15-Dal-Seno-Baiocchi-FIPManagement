package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Championship;
import model.Model;
import model.Team;
import tableModel.MyTeamModel;
import controller.TeamController;

public class TeamView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -3615263799621093916L;
    private JPanel contentPane;
    private JTable teamTable;
    private JButton btnAddTeam;
    private JButton btnDeleteTeam;
    private JButton btnBack;
    private TeamController controller;

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
        this.setTitle("Team View");
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
        
        btnBack = new JButton("Back");
        btnBack.setBounds(6, 492, 117, 29);
        contentPane.add(btnBack);
        
        JLabel lblTeamName = new JLabel("TEAM NAME");
        lblTeamName.setBounds(173, 103, 82, 16);
        contentPane.add(lblTeamName);
        
        JLabel lblCompany = new JLabel("COMPANY");
        lblCompany.setBounds(436, 103, 69, 16);
        contentPane.add(lblCompany);
      
        JLabel lblTeams = new JLabel("TEAMS");
        lblTeams.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblTeams.setBounds(293, 23, 91, 53);
        contentPane.add(lblTeams);
    }
    
    public TeamView(final Model model, Championship ch){
        this();
        this.controller = new TeamController(model, ch);
        teamTable.setModel(new MyTeamModel(model, ch));
        
        teamTable.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					int index = teamTable.getSelectedRow();
					Team team = model.getTeam(ch).get(index);
					new TeamComponentView(team).setVisible(true);;
				}
			}
		});
        
        btnAddTeam.addActionListener(e->{
           AddTeam t = new AddTeam();
           t.attachObserver(new TeamController(model,ch));
           t.setVisible(true);
        });
        
        btnDeleteTeam.addActionListener(e->{
        	int i = teamTable.getSelectedRow();
        	Team remove = (Team) model.getTeam(ch).toArray()[i];
        	controller.removeTeam(remove);
        	teamTable.repaint();
        });
    }
}
