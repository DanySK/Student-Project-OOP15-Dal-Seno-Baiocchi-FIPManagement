package view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.IModel;
import model.Player;
import model.Player.PLAYEROLE;
import model.Staff;
import model.Staff.ROLE;

import com.toedter.calendar.JDateChooser;

import controller.Utils;

public class StatisticView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 2072569797603702405L;
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField cfField;
    private JTextField heightField;
    private JDateChooser calendar;
    private JComboBox<Object> roleBox;
    private JButton btnCancel;
    private JButton btnApplyChanges;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StatisticView frame = new StatisticView();
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
    private StatisticView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 587, 408);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(93, 61, 134, 28);
        contentPane.add(nameTextField);
        nameTextField.setColumns(10);
        
        surnameTextField = new JTextField();
        surnameTextField.setBounds(93, 116, 134, 28);
        contentPane.add(surnameTextField);
        surnameTextField.setColumns(10);
        
        calendar = new JDateChooser();
        calendar.setBounds(79, 182, 134, 28);
        contentPane.add(calendar);
        
        cfField = new JTextField();
        cfField.setBounds(79, 251, 134, 28);
        contentPane.add(cfField);
        cfField.setColumns(10);
        
        roleBox = new JComboBox<>();
        roleBox.setBounds(93, 17, 153, 27);
        contentPane.add(roleBox);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(6, 67, 61, 16);
        contentPane.add(lblName);
        
        JLabel lblSurname = new JLabel("Surname:");
        lblSurname.setBounds(6, 122, 61, 16);
        contentPane.add(lblSurname);
        
        JLabel lblBirth = new JLabel("Birth:");
        lblBirth.setBounds(6, 188, 61, 16);
        contentPane.add(lblBirth);
        
        JLabel lblCf = new JLabel("CF:");
        lblCf.setBounds(6, 257, 61, 16);
        contentPane.add(lblCf);
        
        JLabel lblHeight = new JLabel("Height:");
        lblHeight.setBounds(6, 320, 61, 16);
        contentPane.add(lblHeight);
        
        heightField = new JTextField();
        heightField.setBounds(79, 314, 134, 28);
        contentPane.add(heightField);
        heightField.setColumns(10);
        
        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(6, 21, 61, 16);
        contentPane.add(lblRole);
        
        JPanel panel = new JPanel();
        panel.setBounds(262, 20, 319, 271);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel lblPoints = new JLabel("Points:");
        panel.add(lblPoints);
        
        JLabel setPoints = new JLabel("");
        panel.add(setPoints);
        
        JLabel lblOffRebounds = new JLabel("Off Rebounds:");
        panel.add(lblOffRebounds);
        
        JLabel setOffRebounds = new JLabel("");
        panel.add(setOffRebounds);
        
        JLabel lblDefRebounds = new JLabel("Def Rebounds:");
        panel.add(lblDefRebounds);
        
        JLabel setDefRebounds = new JLabel("");
        panel.add(setDefRebounds);
        
        JLabel lblAssist = new JLabel("Assists:");
        panel.add(lblAssist);
        
        JLabel setAssists = new JLabel("");
        panel.add(setAssists);
        
        JLabel lblBlocks = new JLabel("Blocks:");
        panel.add(lblBlocks);
        
        JLabel setBlocks = new JLabel("");
        panel.add(setBlocks);
        
        JLabel lblPersonalFouls = new JLabel("Personal Fouls:");
        panel.add(lblPersonalFouls);
        
        JLabel setPersonalFouls = new JLabel("");
        panel.add(setPersonalFouls);
        
        JLabel lblLoseBalls = new JLabel("Lose Balls:");
        panel.add(lblLoseBalls);
        
        JLabel setLoseBalls = new JLabel("");
        panel.add(setLoseBalls);
        
        JLabel lblSteals = new JLabel("Steals:");
        panel.add(lblSteals);
        
        JLabel setSteals = new JLabel("");
        panel.add(setSteals);
        
        btnApplyChanges = new JButton("Apply Changes");
        btnApplyChanges.setBounds(280, 326, 134, 29);
        contentPane.add(btnApplyChanges);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(426, 326, 127, 29);
        contentPane.add(btnCancel);
        btnCancel.addActionListener(e->{
            this.setVisible(false);
        });
    }
    
    public StatisticView(Player p,final IModel model){
        this();
        this.roleBox.setModel(new DefaultComboBoxModel<>(PLAYEROLE.values()));
        this.roleBox.setSelectedItem(p.getRole());
        this.nameTextField.setText(p.getName());
        this.surnameTextField.setText(p.getSurname());
        this.calendar.setDate(p.getBirth());
        this.cfField.setText(p.getCF());
        this.heightField.setText(""+p.getHeight());
        btnApplyChanges.addActionListener(e->{
            p.setName(nameTextField.getText());
            p.setSurname(surnameTextField.getText());
            p.setBirth(calendar.getDate());
            p.setRole((PLAYEROLE)roleBox.getSelectedItem());
            p.setCF(cfField.getText());
            p.setHeight(Double.valueOf(heightField.getText()));
            Utils.save(model);
            this.setVisible(false);
        });
    }
    
    public StatisticView(Staff s,final IModel model){
        this();
        this.roleBox.setModel(new DefaultComboBoxModel<>(ROLE.values()));
        this.roleBox.setSelectedItem(s.getRole());
        this.nameTextField.setText(s.getName());
        this.surnameTextField.setText(s.getSurname());
        this.calendar.setDate(s.getBirth());
        this.cfField.setText(s.getCF());
        this.heightField.setEnabled(false);
        btnApplyChanges.addActionListener(e->{
            s.setName(nameTextField.getText());
            s.setSurname(surnameTextField.getText());
            s.setBirth(calendar.getDate());
            s.setRole((ROLE)roleBox.getSelectedItem());
            s.setCF(cfField.getText());
            Utils.save(model);
            this.setVisible(false);
        });
    }
    
   
}
