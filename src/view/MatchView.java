package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Model;
import observer.MatchViewObserver;

public class MatchView extends JFrame implements ObserverInterface<MatchViewObserver>{

	/**
     * 
     */
    private static final long serialVersionUID = -6679819020260822815L;
    private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchView frame = new MatchView();
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
	private MatchView() {
		setBounds(100, 100, 744, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHomeTeam = new JLabel("Home Team");
		lblHomeTeam.setBounds(27, 11, 103, 38);
		contentPane.add(lblHomeTeam);
		
		JLabel lblGuestTeam = new JLabel("Guest Team");
		lblGuestTeam.setBounds(500, 11, 103, 38);
		contentPane.add(lblGuestTeam);
		
		JList homeTeamList = new JList();
		homeTeamList.setBounds(27, 48, 202, 400);
		contentPane.add(homeTeamList);
		
		JList guestTeamList = new JList();
		guestTeamList.setBounds(500, 48, 202, 400);
		contentPane.add(guestTeamList);
		
		JButton btnSaveMatch = new JButton("SaveMatch");
		btnSaveMatch.setBounds(500, 471, 89, 38);
		contentPane.add(btnSaveMatch);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(613, 471, 89, 38);
		contentPane.add(btnCancel);
		
		JButton btnAdd2Point = new JButton("Add 2 Points");
		btnAdd2Point.setBounds(238, 116, 121, 57);
		contentPane.add(btnAdd2Point);
		
		JButton btnRemove2Point = new JButton("Remove 2 Points");
		btnRemove2Point.setBounds(369, 116, 121, 57);
		contentPane.add(btnRemove2Point);
		
		JButton btnAdd3Point = new JButton("Add 3 Points");
		btnAdd3Point.setBounds(237, 184, 121, 57);
		contentPane.add(btnAdd3Point);
		
		JButton btnRemove3Point = new JButton("Remove 3 Points");
		btnRemove3Point.setBounds(368, 184, 121, 57);
		contentPane.add(btnRemove3Point);
		
		JButton addRimbalzo = new JButton("Add Rebound");
		addRimbalzo.setBounds(238, 252, 121, 57);
		contentPane.add(addRimbalzo);
		
		JButton btnRemoveRimbalzo = new JButton("Remove Rebound");
		btnRemoveRimbalzo.setBounds(369, 252, 121, 57);
		contentPane.add(btnRemoveRimbalzo);
		
		JButton btnAddPoint = new JButton("Add 1 Point");
		btnAddPoint.setBounds(238, 48, 121, 57);
		contentPane.add(btnAddPoint);
		
		JButton btnRemovePoint = new JButton("Remove 1 Point");
		btnRemovePoint.setBounds(369, 48, 121, 57);
		contentPane.add(btnRemovePoint);
		
		JButton btnAddStop = new JButton("Add Block");
		btnAddStop.setBounds(238, 320, 121, 57);
		contentPane.add(btnAddStop);
		
		JButton btnRemoveStop = new JButton("Remove Block");
		btnRemoveStop.setBounds(369, 320, 121, 57);
		contentPane.add(btnRemoveStop);
		
		JButton btnRemoveFaul = new JButton("Remove Foul");
		btnRemoveFaul.setBounds(370, 388, 121, 57);
		contentPane.add(btnRemoveFaul);
		
		JButton btnAddFaul = new JButton("Add Foul");
		btnAddFaul.setBounds(239, 388, 121, 57);
		contentPane.add(btnAddFaul);
	}

	public MatchView(final Model model){
		this();
		
		
		
	}

	@Override
	public void attachObserver(MatchViewObserver observer) {
		// TODO Auto-generated method stub
		
	}
}
