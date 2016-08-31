package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.Utils;
import model.IModel;
/**
 * The home View of the app
 * @author lucadalseno
 *
 */
public class MainView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 9199009276340778940L;
    private JPanel contentPane;
    public static enum LoginType{adm,user};
    IModel model;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView frame = new MainView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 549);
        
        model = Utils.loading();
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton championshipBtn = new JButton("Championship");
        championshipBtn.setBounds(101, 439, 172, 29);
        contentPane.add(championshipBtn);
        championshipBtn.addActionListener(e->{
            LoginDialog lD = new LoginDialog(model);
            LoginController contr = new LoginController(LoginType.adm, model);
            contr.setView(lD);
            lD.setLocation(250, 250);
            lD.setVisible(true); 
        });
        
        JButton matchBtn = new JButton("Match");
        matchBtn.setBounds(424, 439, 172, 29);
        contentPane.add(matchBtn);
        matchBtn.addActionListener(e->{
            LoginDialog lD = new LoginDialog(model);
            LoginController contr = new LoginController(LoginType.user,model);
            contr.setView(lD);
            lD.setLocation(250, 250);
            lD.setVisible(true); 
        });
        
        String path = "image/logone.png";
        ImageIcon image = new ImageIcon(path);
        JLabel logoLbl = new JLabel(image);
        logoLbl.setBounds(86, 51, 522, 334);
        contentPane.add(logoLbl);
    }
}