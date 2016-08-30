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
import model.ChampionshipImpl;
import model.Model;
import observer.ChampionshipObserver;
import tableModel.MyChampionshipModel;
import controller.ChampionshipController;


public class ChampionshipView extends JFrame  implements ObserverInterface<ChampionshipObserver>{

    /**
     * 
     */
    private static final long serialVersionUID = 4097624461142333134L;
    private JPanel contentPane;
    private JTable champTable;
    private JButton addChampBtn;
    private JButton deleteChamp;
    private ChampionshipObserver obs;
    private JButton btnBack;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChampionshipView frame = new ChampionshipView(new Model());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param model 
     */
    private ChampionshipView() {
        this.setTitle("Championship View");
        setBounds(100, 100, 692, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        addChampBtn = new JButton("Add Championship");
        addChampBtn.setBounds(133, 415, 179, 29);
        contentPane.add(addChampBtn);
        
        deleteChamp = new JButton("Delete Championship");
        deleteChamp.setBounds(388, 415, 179, 29);
        contentPane.add(deleteChamp);
        
        champTable = new JTable();
        champTable.setBounds(108, 131, 492, 245);
        contentPane.add(champTable);
        
        JLabel lblChampionship = new JLabel("DIVISION");
        lblChampionship.setBounds(173, 103, 82, 16);
        contentPane.add(lblChampionship);
        
        JLabel lblZone = new JLabel("ZONE");
        lblZone.setBounds(436, 103, 82, 16);
        contentPane.add(lblZone);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(549, 470, 117, 29);
        contentPane.add(btnBack);   
        
        JLabel lblChampionship_1 = new JLabel("CHAMPIONSHIP");
        lblChampionship_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblChampionship_1.setBounds(251, 23, 200, 53);
        contentPane.add(lblChampionship_1);
    }
    
    public ChampionshipView(final Model model){
    	this();
    	champTable.setModel(new MyChampionshipModel(model));
    	champTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					int index = ((JTable)e.getSource()).getSelectedRow();
					Championship ch = (Championship) model.getChampionship().toArray()[index];
					new TeamView(model, ch).setVisible(true);
				}
			}
		});
        addChampBtn.addActionListener(e->{
            AddChamp c = new AddChamp();
            c.attachObserver(new ChampionshipController(model));
            c.repaint();
            c.setVisible(true);
        });
        deleteChamp.addActionListener(e->{
            this.attachObserver(new ChampionshipController(model));
            obs.deleteChampionship((ChampionshipImpl) model.getChampionship().toArray()[champTable.getSelectedRow()]);
            champTable.repaint();
        });
        
        btnBack.addActionListener(e->{
        	this.setVisible(false);
        });
    }

    @Override
    public void attachObserver(ChampionshipObserver observer) {
        this.obs = observer;
        
    }
}
