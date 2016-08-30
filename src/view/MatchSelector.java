package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Championship;
import model.IModel;
import model.Model;
import observer.MatchSelectorObserver;

public class MatchSelector extends JFrame implements ObserverInterface<MatchSelectorObserver> {

	private JPanel contentPane;
	private JComboBox comboBoxHome;
	private JComboBox comboBoxGuest;
	private JButton btnStartMatch;
	private JButton btnBack;
	private MatchSelectorObserver observer;
	private Championship ch;
	private JLabel lblSelectChampionship;
	private JComboBox comboBoxChampionship;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchSelector frame = new MatchSelector();
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
	private MatchSelector() {
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHomeTeam = new JLabel("Home Team");
		lblHomeTeam.setBounds(34, 77, 91, 30);
		contentPane.add(lblHomeTeam);
		
		JLabel lblGuestTeam = new JLabel("Guest Team");
		lblGuestTeam.setBounds(252, 77, 98, 30);
		contentPane.add(lblGuestTeam);
		
		comboBoxHome = new JComboBox();
		comboBoxHome.setBounds(34, 116, 134, 20);
		contentPane.add(comboBoxHome);
		
		comboBoxGuest = new JComboBox();
		comboBoxGuest.setBounds(252, 116, 134, 20);
		contentPane.add(comboBoxGuest);
		
		btnStartMatch = new JButton("Start Match");
		btnStartMatch.setBounds(34, 147, 134, 23);
		contentPane.add(btnStartMatch);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(252, 147, 134, 23);
		contentPane.add(btnBack);
		
		lblSelectChampionship = new JLabel("Select Championship");
		lblSelectChampionship.setBounds(34, 11, 118, 20);
		contentPane.add(lblSelectChampionship);
		
		comboBoxChampionship = new JComboBox();
		comboBoxChampionship.setBounds(34, 46, 134, 20);
		contentPane.add(comboBoxChampionship);
	}
	
	public MatchSelector(final IModel model){
		this();
		
		btnStartMatch.addActionListener(e->{
			this.setVisible(false);
			new MatchView(model).setVisible(true);
		});
		
		btnBack.addActionListener(e->{
			this.setVisible(false);
		});
	}
	
	@Override
	public void attachObserver(MatchSelectorObserver observer) {
		this.observer = observer;
	}
}
