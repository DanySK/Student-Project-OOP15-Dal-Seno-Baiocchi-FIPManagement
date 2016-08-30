package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.IModel;
import observer.MatchViewObserver;

public class MatchView extends JFrame implements ObserverInterface<MatchViewObserver>{

	/**
     * 
     */
    private static final long serialVersionUID = -6679819020260822815L;
    private JPanel contentPane;
    private JButton addOnePoint;
    private JButton removeOnePoint;
    private JButton addTwoPoints;
    private JButton removeTwoPoints;
    private JButton addThreePoints;
    private JButton removeThreePoints;
    private JButton addOffRebound;
    private JButton removeOffRebound;
    private JButton addDefRebound;
    private JButton removeDefRebound;
    private JButton addAssist;
    private JButton removeAssist;
    private JButton addBlock;
    private JButton removeBlock;
    private JButton addPersonalFoul;
    private JButton removePersonaFoul;
    private JButton addLoseBall;
    private JButton removeLoseBall;
    private JButton addSteal;
    private JButton removeSteal;
    private JButton saveMatch;
    private JButton cancel;

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
		lblGuestTeam.setBounds(514, 11, 103, 38);
		contentPane.add(lblGuestTeam);
		
		JList homeTeamList = new JList();
		homeTeamList.setBounds(27, 48, 202, 400);
		contentPane.add(homeTeamList);
		
		JList guestTeamList = new JList();
		guestTeamList.setBounds(510, 48, 202, 400);
		contentPane.add(guestTeamList);
		
		JPanel panel = new JPanel();
		panel.setBounds(241, 30, 260, 476);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		addOnePoint = new JButton("Add 1 Point");
		panel.add(addOnePoint);
		
		removeOnePoint = new JButton("Remove 1 Point");
		panel.add(removeOnePoint);
		
		addTwoPoints = new JButton("Add 2 Points");
		panel.add(addTwoPoints);
		
		removeTwoPoints = new JButton("Remove 2 Points");
		panel.add(removeTwoPoints);
		
		addThreePoints = new JButton("Add 3 Points");
		panel.add(addThreePoints);
		
		removeThreePoints = new JButton("Remove 3 Points");
		panel.add(removeThreePoints);
		
		addOffRebound = new JButton("Add OFF Rebound");
		panel.add(addOffRebound);
		
		removeOffRebound = new JButton("Remove OFF.Rebound");
		removeOffRebound.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		panel.add(removeOffRebound);
		
		addDefRebound = new JButton("Add DEF Rebound");
		panel.add(addDefRebound);
		
		removeDefRebound = new JButton("Remove DEF Rebound");
		removeDefRebound.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		panel.add(removeDefRebound);
		
		addAssist = new JButton("Add Assist");
		panel.add(addAssist);
		
		removeAssist = new JButton("Remove Assist");
		panel.add(removeAssist);
		
		addBlock = new JButton("Add Block");
		panel.add(addBlock);
		
		removeBlock = new JButton("Remove Block");
		panel.add(removeBlock);
		
		addPersonalFoul = new JButton("Add  Personal Foul");
		panel.add(addPersonalFoul);
		
		removePersonaFoul = new JButton("Remove Personal Foul");
		removePersonaFoul.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		panel.add(removePersonaFoul);
		
		addLoseBall = new JButton("Add Lose Ball");
		panel.add(addLoseBall);
		
		removeLoseBall = new JButton("Remove Lose Ball");
		panel.add(removeLoseBall);
		
		addSteal = new JButton("Add Steal");
		panel.add(addSteal);
		
		removeSteal = new JButton("Remove Steal");
		panel.add(removeSteal);
		
		saveMatch = new JButton("SaveMatch");
		saveMatch.setBounds(517, 492, 86, 43);
		contentPane.add(saveMatch);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(635, 492, 86, 43);
		contentPane.add(cancel);
	}

	public MatchView(final IModel model){
		this();
		
		
		
	}

	@Override
	public void attachObserver(MatchViewObserver observer) {
		// TODO Auto-generated method stub
		
	}
}
