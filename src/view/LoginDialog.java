package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.sun.xml.internal.ws.Closeable;

public class LoginDialog extends JDialog implements LoginDialogInterface {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    public JTextField userTextField;
    public JTextField pswTextfield;
    private LoginObserver obs;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            LoginDialog dialog = new LoginDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public LoginDialog() {
        setBounds(100, 100, 401, 162);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            userTextField = new JTextField();
            userTextField.setBounds(133, 6, 134, 28);
            contentPanel.add(userTextField);
            userTextField.setColumns(10);
        }
        {
            JLabel userLbl = new JLabel("Username");
            userLbl.setBounds(23, 12, 84, 16);
            contentPanel.add(userLbl);
        }
        {
            JLabel passLbl = new JLabel("Password");
            passLbl.setBounds(23, 56, 68, 16);
            contentPanel.add(passLbl);
        }
        
        pswTextfield = new JTextField();
        pswTextfield.setBounds(133, 50, 134, 28);
        contentPanel.add(pswTextfield);
        pswTextfield.setColumns(10);
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
                    obs.doLogin(userTextField.getText(), pswTextfield.getText());
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
    
    public static interface LoginObserver{
        
        /**
         * check if the login is correct
         */
        void doLogin(String user,String pwd);
        
    }
    
    public void attachObserver(LoginObserver observer){
        this.obs = observer;
    }
    @Override
    public void clearInterface() {
        // TODO Auto-generated method stub
        
    }

   /* @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();
        if(buttonPressed =="Cancel"){
            this.setVisible(false);
        } else if(buttonPressed == "OK"){
            this.obs.doLogin(userTextField.getText(), pswTextfield.getText());
        }
        
    }*/

   
}


