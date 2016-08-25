package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.ComponentController;
import controller.TeamController;
import model.Championship;
import model.Model;
import model.Player;
import model.Team;
import observer.TeamComponentObserver;
import tableModel.MyComponentModel;

public class TeamComponentView extends JFrame implements ObserverInterface<TeamComponentObserver>{

    private JPanel contentPane;
    private JTable componentsTable;
    private JButton deleteComponent;
    private JButton addComponent;
    private JButton btnBack;
    private TeamComponentObserver observer;

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
    private TeamComponentView() {
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
        
        btnBack = new JButton("Back");
        btnBack.setBounds(6, 492, 117, 29);
        contentPane.add(btnBack);
        
        JLabel lblTeamName = new JLabel("NAME");
        lblTeamName.setBounds(173, 103, 82, 16);
        contentPane.add(lblTeamName);
        
        JLabel lblCompany = new JLabel("ROLE");
        lblCompany.setBounds(436, 103, 69, 16);
        contentPane.add(lblCompany);
    }
    
    
    
    public TeamComponentView(final Team team){
    	this();
    	observer = new ComponentController(team);
    	componentsTable.setModel(new MyComponentModel( team));
    	componentsTable.addMouseListener(new MouseAdapter(){
    		@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					int index = ((JTable)e.getSource()).getSelectedRow();
					Player player = team.getPlayers().get(index);
					
				}
			}
    	});
    	addComponent.addActionListener(e->{
    		AddComponent ac = new AddComponent();
    		ac.attachObserver(observer);
    		ac.setVisible(true);
    	});
    	
    	deleteComponent.addActionListener(e->{
    		
    	});
    }
    

	@Override
	public void clearInterface() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachObserver(TeamComponentObserver observer) {
		this.observer = observer;
	}
   
}
