package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import controller.LoginController;

public class MainView extends JFrame {

    private JPanel contentPane;

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

    /**
     * Create the frame.
     */
    @SuppressWarnings("deprecation")
    public MainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton championshipBtn = new JButton("Championship");
        championshipBtn.setBounds(101, 439, 172, 29);
        contentPane.add(championshipBtn);
        championshipBtn.addActionListener(e->{
            LoginDialog lD = new LoginDialog();
            LoginController contr = new LoginController();
            contr.setView(lD);
            lD.setLocation(250, 250);
            lD.setVisible(true); 
        });
        
        JButton matchBtn = new JButton("Match");
        matchBtn.setBounds(424, 439, 172, 29);
        contentPane.add(matchBtn);
        matchBtn.addActionListener(e->{
            LoginDialog lD = new LoginDialog();
            lD.setLocation(250, 250);
            lD.setVisible(true); 
        });
        
        String path = "image/logone.png";
        ImageIcon image = new ImageIcon(path);
        JLabel logoLbl = new JLabel(image);
        logoLbl.setBounds(86, 51, 522, 334);
        contentPane.add(logoLbl);
    }
    
    public interface MainViewObserver{
        
    }
}
