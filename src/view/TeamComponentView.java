package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.IModel;
import model.Player;
import model.Staff;
import model.Team;
import model.TeamImpl;
import observer.TeamComponentObserver;
import tableModel.MyComponentModel;
import tableModel.MyComponentModel.CompononentType;
import controller.ComponentController;
import controller.Utils;
/**
 * The team component view of the app
 * @author lucadalseno
 *
 */
public class TeamComponentView extends JFrame implements ObserverInterface<TeamComponentObserver>{

    /**
     * 
     */
    private static final long serialVersionUID = 6121024019716588087L;
    private JPanel contentPane;
    private JTable componentsTable;
    private JButton deleteComponent;
    private JButton addComponent;
    private JButton btnBack;
    private TeamComponentObserver observer;
    private JLabel lblSurname;
    private JLabel lblBirth;
    private JLabel lblHeight;
    private JLabel lblCf;
    private JTable staffTable;
    private JButton removeStaff;
    private JLabel lblRoster;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TeamComponentView frame = new TeamComponentView(Utils.loading(), new TeamImpl("","","","",""));
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
        this.setTitle("Team Component View");
        setBounds(100, 100, 692, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        componentsTable = new JTable();
        componentsTable.setBounds(108, 119, 492, 172);
        contentPane.add(componentsTable);
        
        addComponent = new JButton("Add Component");
        addComponent.setBounds(108, 415, 146, 29);
        contentPane.add(addComponent);
        
        deleteComponent = new JButton("Remove Player");
        deleteComponent.setBounds(476, 415, 124, 29);
        contentPane.add(deleteComponent);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(18, 477, 117, 29);
        contentPane.add(btnBack);
        
        JLabel lblTeamName = new JLabel("Name");
        lblTeamName.setBounds(108, 103, 50, 16);
        contentPane.add(lblTeamName);
        
        JLabel lblCompany = new JLabel("Role");
        lblCompany.setBounds(438, 103, 50, 16);
        contentPane.add(lblCompany);
        
        lblSurname = new JLabel("Surname");
        lblSurname.setBounds(188, 103, 62, 16);
        contentPane.add(lblSurname);
        
        lblBirth = new JLabel("Birth");
        lblBirth.setBounds(516, 103, 50, 16);
        contentPane.add(lblBirth);
        
        lblHeight = new JLabel("Height");
        lblHeight.setBounds(278, 103, 62, 16);
        contentPane.add(lblHeight);
        
        lblCf = new JLabel("CF");
        lblCf.setBounds(365, 103, 31, 16);
        contentPane.add(lblCf);
        lblRoster = new JLabel();
        lblRoster.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblRoster.setBounds(216, 23, 282, 53);
        contentPane.add(lblRoster);
        
        staffTable = new JTable();
        staffTable.setBounds(108, 302, 492, 91);
        contentPane.add(staffTable);
        
        removeStaff = new JButton("Remove Staff");
        removeStaff.setBounds(366, 415, 109, 29);
        contentPane.add(removeStaff);
    }
    
    
    
    public TeamComponentView(final IModel model, final Team team){
    	this();
    	lblRoster.setText(team.getName()+" ROSTER");
    	observer = new ComponentController(model, team);
    	componentsTable.setModel(new MyComponentModel(team, CompononentType.PLAYER));
    	staffTable.setModel(new MyComponentModel(team, CompononentType.STAFF));
    	staffTable.addMouseListener(new MouseAdapter() {
    	    public void mouseClicked(MouseEvent e){
    	        staffTable.repaint();
    	        if(e.getClickCount() == 2){
    	            int index = ((JTable)e.getSource()).getSelectedRow();
    	            Staff staff = team.getStaff().get(index);
    	            new StatisticView(staff,model).setVisible(true);;
    	        }
    	    }
        });
    	componentsTable.addMouseListener(new MouseAdapter(){
    		@Override
			public void mouseClicked(MouseEvent e) {
    			componentsTable.repaint();
				if(e.getClickCount() == 2){
					int index = ((JTable)e.getSource()).getSelectedRow();
					Player player = team.getPlayers().get(index);
					new StatisticView(player,model).setVisible(true);;
				}
			}
    	});
    	addComponent.addActionListener(e->{
    		AddComponent ac = new AddComponent();
    		ac.attachObserver(observer);
    		ac.setVisible(true);
    	});
    	
    	deleteComponent.addActionListener(e->{
    	  if((JOptionPane.showConfirmDialog(this, "You want to delete this Player?",
                  "WARNING", JOptionPane.YES_NO_CANCEL_OPTION)) == JOptionPane.YES_OPTION){
    		int index = componentsTable.getSelectedRow();
    		if(index>=0){
				Player player = team.getPlayers().get(index);
	    		observer.removePlayer(player);
    		}
    	  }
    	});
    	
    	removeStaff.addActionListener(e->{
    	  if((JOptionPane.showConfirmDialog(this, "You want to delete this Staff?",
                  "WARNING", JOptionPane.YES_NO_CANCEL_OPTION)) == JOptionPane.YES_OPTION){
    		int index = staffTable.getSelectedRow();
    		if(index>=0){
        		Staff staff = team.getStaff().get(index);
    			observer.removeStaff(staff);
    		}
    	  }
    	});
    	  	   	
    	btnBack.addActionListener(e->{
    		this.setVisible(false);
    	});
    }
    
	@Override
	public void attachObserver(TeamComponentObserver observer) {
		this.observer = observer;
	}
}
