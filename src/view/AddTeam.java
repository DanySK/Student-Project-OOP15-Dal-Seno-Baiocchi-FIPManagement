package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;


import model.CompanyImpl;
import observer.TeamObserver;

public class AddTeam extends JDialog implements ObserverInterface<TeamObserver> {

    /**
     * 
     */
    private static final long serialVersionUID = 5849733983802992020L;
    private final JPanel contentPanel = new JPanel();
    private JTextField nameTextfield;
    private JTextField homeColourTextfield;
    private JTextField transferColourTextField;
    private JTextField companyTextfield;
    private TeamObserver obs;
    private JTextField vatTextfield;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AddTeam dialog = new AddTeam();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddTeam() {
        setBounds(100, 100, 455, 341);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        nameTextfield = new JTextField();
        nameTextfield.setBounds(148, 23, 134, 28);
        contentPanel.add(nameTextfield);
        nameTextfield.setColumns(10);
        
        homeColourTextfield = new JTextField();
        homeColourTextfield.setBounds(148, 78, 134, 28);
        contentPanel.add(homeColourTextfield);
        homeColourTextfield.setColumns(10);
        
        transferColourTextField = new JTextField();
        transferColourTextField.setBounds(148, 132, 134, 28);
        contentPanel.add(transferColourTextField);
        transferColourTextField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setBounds(6, 29, 61, 16);
        contentPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Home Colour:");
        lblNewLabel_1.setBounds(6, 84, 98, 16);
        contentPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Transfer Colour:");
        lblNewLabel_2.setBounds(6, 138, 113, 16);
        contentPanel.add(lblNewLabel_2);
        
        JLabel lblCompanyName = new JLabel("Company Name:");
        lblCompanyName.setBounds(6, 196, 113, 16);
        contentPanel.add(lblCompanyName);
        
        companyTextfield = new JTextField();
        companyTextfield.setBounds(148, 190, 134, 28);
        contentPanel.add(companyTextfield);
        companyTextfield.setColumns(10);
        
        JLabel lblCompanyVat = new JLabel("Company VAT:");
        lblCompanyVat.setBounds(6, 247, 98, 16);
        contentPanel.add(lblCompanyVat);
        
        vatTextfield = new JTextField();
        vatTextfield.setBounds(148, 241, 134, 28);
        contentPanel.add(vatTextfield);
        vatTextfield.setColumns(10);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton addButton = new JButton("Add");
                addButton.setActionCommand("Add");
                buttonPane.add(addButton);
                addButton.addActionListener(e->{
                    obs.addTeam(nameTextfield.getText(), homeColourTextfield.getText(), transferColourTextField.getText());
                });
                getRootPane().setDefaultButton(addButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(e->{
                    this.setVisible(false);
                });
                buttonPane.add(cancelButton);
            }
        }
    }

    @Override
    public void attachObserver(TeamObserver observer) {
        this.obs = observer;        
    }

    @Override
    public void clearInterface() {
        // TODO Auto-generated method stub
        
    }
}
