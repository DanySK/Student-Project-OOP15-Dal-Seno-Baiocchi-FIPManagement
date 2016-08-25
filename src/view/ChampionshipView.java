package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.motif.resources.motif;
import com.sun.javafx.scene.control.SelectedCellsMap;
import com.sun.rowset.internal.Row;

import controller.ChampionshipController;
import javafx.scene.control.SingleSelectionModel;
import model.ChampionshipImpl;
import model.Model;
import model.MyTableModel;

import javax.swing.JLabel;

import observer.ChampionshipObserver;


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
        btnBack.setBounds(6, 492, 117, 29);
        contentPane.add(btnBack);   
    }
    
    public ChampionshipView(final Model model){
    	this();
    	champTable.setModel(new MyTableModel(model));
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
    }

    @Override
    public void attachObserver(ChampionshipObserver observer) {
        this.obs = observer;
        
    }

    @Override
    public void clearInterface() {
        // TODO Auto-generated method stub
        
    }
}
