package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import observer.TeamComponentObserver;

import java.awt.Font;

public class AddComponent extends JDialog implements ObserverInterface<TeamComponentObserver> {

    private final JPanel contentPanel = new JPanel();
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ddField;
    private JTextField mmField;
    private JTextField yyField;
    private JTextField cfField;
    private JTextField heightField;
    private JTextField roleField;
    private TeamComponentObserver obs;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddComponent dialog = new AddComponent();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddComponent() {
        setBounds(100, 100, 451, 411);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JComboBox typeBox = new JComboBox();
        typeBox.setModel(new DefaultComboBoxModel(new String[] {"PLAYER", "COACH", "STAFF", "MANAGER"}));
        typeBox.setBounds(141, 18, 134, 27);
        contentPanel.add(typeBox);
        
        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(24, 22, 61, 16);
        contentPanel.add(lblType);
        
        nameField = new JTextField();
        nameField.setBounds(133, 67, 134, 28);
        contentPanel.add(nameField);
        nameField.setColumns(10);
        
        surnameField = new JTextField();
        surnameField.setBounds(133, 109, 134, 28);
        contentPanel.add(surnameField);
        surnameField.setColumns(10);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(24, 73, 61, 16);
        contentPanel.add(lblName);
        
        JLabel lblSurname = new JLabel("Surname:");
        lblSurname.setBounds(24, 115, 61, 16);
        contentPanel.add(lblSurname);
        
        ddField = new JTextField();
        ddField.setBounds(112, 162, 38, 28);
        contentPanel.add(ddField);
        ddField.setColumns(10);
        
        JLabel lblBirth = new JLabel("Birth:");
        lblBirth.setBounds(24, 168, 61, 16);
        contentPanel.add(lblBirth);
        
        mmField = new JTextField();
        mmField.setBounds(175, 162, 38, 28);
        contentPanel.add(mmField);
        mmField.setColumns(10);
        
        yyField = new JTextField();
        yyField.setBounds(245, 162, 68, 28);
        contentPanel.add(yyField);
        yyField.setColumns(10);
        
        JLabel lblDd = new JLabel("dd");
        lblDd.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblDd.setBounds(97, 169, 12, 16);
        contentPanel.add(lblDd);
        
        JLabel lblMm = new JLabel("mm");
        lblMm.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblMm.setBounds(160, 169, 21, 16);
        contentPanel.add(lblMm);
        
        JLabel lblYyyy = new JLabel("yyyy");
        lblYyyy.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblYyyy.setBounds(223, 169, 21, 16);
        contentPanel.add(lblYyyy);
        
        cfField = new JTextField();
        cfField.setBounds(133, 206, 134, 28);
        contentPanel.add(cfField);
        cfField.setColumns(10);
        
        JLabel lblCf = new JLabel("CF:");
        lblCf.setBounds(24, 212, 61, 16);
        contentPanel.add(lblCf);
        
        JLabel lblHeight = new JLabel("Height:");
        lblHeight.setBounds(24, 252, 61, 16);
        contentPanel.add(lblHeight);
        
        heightField = new JTextField();
        heightField.setBounds(133, 246, 134, 28);
        contentPanel.add(heightField);
        heightField.setColumns(10);
        
        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(24, 298, 61, 16);
        contentPanel.add(lblRole);
        
        roleField = new JTextField();
        roleField.setBounds(133, 292, 134, 28);
        contentPanel.add(roleField);
        roleField.setColumns(10);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton addButton = new JButton("Add");
                addButton.setActionCommand("OK");
                buttonPane.add(addButton);
                getRootPane().setDefaultButton(addButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    @Override
    public void attachObserver(TeamComponentObserver observer) {
        this.obs = observer;        
    }

    @Override
    public void clearInterface() {
        // TODO Auto-generated method stub
        
    }
}
