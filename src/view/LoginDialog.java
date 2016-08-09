package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.sun.xml.internal.ws.Closeable;

public class LoginDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;

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
            textField = new JTextField();
            textField.setBounds(133, 6, 134, 28);
            contentPanel.add(textField);
            textField.setColumns(10);
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
        
        textField_1 = new JTextField();
        textField_1.setBounds(133, 50, 134, 28);
        contentPanel.add(textField_1);
        textField_1.setColumns(10);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
                
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
}
