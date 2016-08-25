package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Player.PLAYEROLE;
import model.Staff.ROLE;
import observer.TeamComponentObserver;

public class AddComponent extends JDialog implements ObserverInterface<TeamComponentObserver> {

    /**
     * 
     */
    private static final long serialVersionUID = -1833110520800729619L;
    private final JPanel contentPanel = new JPanel();
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ddField;
    private JTextField mmField;
    private JTextField yyField;
    private JTextField cfField;
    private JTextField heightField;
    private TeamComponentObserver obs;
    private JComboBox<Object> roleBox;
    private String[] type = new String[]{"PLAYER","STAFF"};

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
        
        roleBox = new JComboBox<Object>();
        roleBox.setBounds(141, 72, 134, 27);
        contentPanel.add(roleBox);
        
        JComboBox<String> typeBox = new JComboBox<String>();
        typeBox.setModel(new DefaultComboBoxModel<String>(type));
        roleBox.setModel(new DefaultComboBoxModel<>(PLAYEROLE.values()));
        typeBox.addActionListener(e->{
            if(typeBox.getSelectedItem().equals(type[0])){
            roleBox.setModel(new DefaultComboBoxModel<Object>(PLAYEROLE.values()));
            heightField.setEnabled(true);
            } else {
                roleBox.setModel(new DefaultComboBoxModel<Object>(ROLE.values()));
                heightField.setEnabled(false);
            }
        });
        typeBox.setBounds(141, 18, 134, 27);
        contentPanel.add(typeBox);
        
        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(24, 22, 61, 16);
        contentPanel.add(lblType);
        
        nameField = new JTextField();
        nameField.setBounds(141, 123, 134, 28);
        contentPanel.add(nameField);
        nameField.setColumns(10);
        
        surnameField = new JTextField();
        surnameField.setBounds(141, 163, 134, 28);
        contentPanel.add(surnameField);
        surnameField.setColumns(10);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(24, 129, 61, 16);
        contentPanel.add(lblName);
        
        JLabel lblSurname = new JLabel("Surname:");
        lblSurname.setBounds(24, 169, 61, 16);
        contentPanel.add(lblSurname);
        
        ddField = new JTextField();
        ddField.setBounds(112, 213, 38, 28);
        contentPanel.add(ddField);
        ddField.setColumns(10);
        
        JLabel lblBirth = new JLabel("Birth:");
        lblBirth.setBounds(24, 219, 61, 16);
        contentPanel.add(lblBirth);
        
        mmField = new JTextField();
        mmField.setBounds(173, 213, 38, 28);
        contentPanel.add(mmField);
        mmField.setColumns(10);
        
        yyField = new JTextField();
        yyField.setBounds(245, 213, 68, 28);
        contentPanel.add(yyField);
        yyField.setColumns(10);
        
        JLabel lblDd = new JLabel("dd");
 lblDd.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblDd.setBounds(97, 220, 12, 16);
        contentPanel.add(lblDd);
        
        JLabel lblMm = new JLabel("mm");
        lblMm.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblMm.setBounds(152, 220, 21, 16);
        contentPanel.add(lblMm);
        
        JLabel lblYyyy = new JLabel("yyyy");
        lblYyyy.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        lblYyyy.setBounds(223, 220, 21, 16);
        contentPanel.add(lblYyyy);
        
        cfField = new JTextField();
        cfField.setBounds(122, 260, 134, 28);
        contentPanel.add(cfField);
        cfField.setColumns(10);
        
        JLabel lblCf = new JLabel("CF:");
        lblCf.setBounds(24, 266, 61, 16);
        contentPanel.add(lblCf);
        
        JLabel lblHeight = new JLabel("Height:");
        lblHeight.setBounds(24, 306, 61, 16);
        contentPanel.add(lblHeight);
        
        heightField = new JTextField();
        heightField.setBounds(122, 300, 134, 28);
        contentPanel.add(heightField);
        heightField.setColumns(10);
        
        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(24, 76, 61, 16);
        contentPanel.add(lblRole);    
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton addButton = new JButton("Add");
                addButton.setActionCommand("OK");
                buttonPane.add(addButton);
                addButton.addActionListener(e->{
                    Calendar birth = Calendar.getInstance();
                    birth.set(Integer.valueOf(yyField.getText()), Integer.valueOf(mmField.getText()), Integer.valueOf(ddField.getText()));
                    if(typeBox.getSelectedItem().equals(type[0])){
                        obs.addPlayer(nameField.getText(), surnameField.getText(), (PLAYEROLE)roleBox.getSelectedItem(), Double.valueOf(heightField.getText()), cfField.getText(), birth.getTime());
                    } else {
                        obs.addStaff(nameField.getText(), surnameField.getText(), (ROLE)roleBox.getSelectedItem(), cfField.getText(),birth.getTime());
                    }
                    this.setVisible(false);
                });
                getRootPane().setDefaultButton(addButton);
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
    public void attachObserver(TeamComponentObserver observer) {
        this.obs = observer;        
    }

    @Override
    public void clearInterface() {
        // TODO Auto-generated method stub
        
    }
}