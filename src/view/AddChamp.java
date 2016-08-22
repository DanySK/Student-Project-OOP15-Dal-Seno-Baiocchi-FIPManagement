package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import observer.ChampionshipObserver;
import model.Division;
import model.Model;
import model.MyTableModel;
import model.Zone;
public class AddChamp extends JDialog implements ObserverInterface<ChampionshipObserver> {

    /**
     * 
     */
    private static final long serialVersionUID = 73893420932703563L;
    private final JPanel contentPanel = new JPanel();
    private ChampionshipObserver obs;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddChamp dialog = new AddChamp();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddChamp() {
        setBounds(100, 100, 410, 231);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Division:");
        lblNewLabel.setBounds(42, 43, 75, 16);
        contentPanel.add(lblNewLabel);
        
        JLabel lblZone = new JLabel("Zone:");
        lblZone.setBounds(42, 106, 75, 16);
        contentPanel.add(lblZone);
        
        JComboBox divisionBox = new JComboBox(Division.values());
        divisionBox.setBounds(188, 39, 145, 27);
        contentPanel.add(divisionBox);
        
        JComboBox zoneBox = new JComboBox(Zone.values());
        zoneBox.setBounds(188, 102, 145, 27);
        contentPanel.add(zoneBox);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
                okButton.addActionListener(e->{
                   obs.addChampionship((Division)divisionBox.getSelectedItem(), (Zone) zoneBox.getSelectedItem()); 
                });
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
                cancelButton.addActionListener(e->{
                    this.setVisible(false);
                });
            }
        }
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
