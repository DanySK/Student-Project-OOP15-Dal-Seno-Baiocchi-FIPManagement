package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.IModel;
import model.Player;
import model.StatisticModel;
import model.StatisticModelImpl;
import model.Statistics;
import model.Team;
import observer.MatchViewObserver;
import tableModel.MyMatchModel;
import controller.MatchViewController;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class MatchView extends JFrame implements ObserverInterface<MatchViewObserver>{

	/**
     * 
     */
    private static final long serialVersionUID = -6679819020260822815L;
    private JPanel contentPane;
	private Team guestTeam;
	private Team homeTeam;
	private IModel model;
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
    private JTable homeTable;
    private JTable guestTable;
    private JScrollPane homeScrollPane;
    private JScrollPane guestScrollPane;
    private JLabel lblHomeTeam;
    private JLabel lblGuestTeam;

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
		setBounds(100, 100, 1208, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHomeTeam = new JLabel("Home Team");
		lblHomeTeam.setBounds(22, 11, 103, 38);
		contentPane.add(lblHomeTeam);
		
		lblGuestTeam = new JLabel("Guest Team");
		lblGuestTeam.setBounds(751, 11, 103, 38);
		contentPane.add(lblGuestTeam);
		
		JPanel panel = new JPanel();
		panel.setBounds(466, 37, 260, 476);
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
		saveMatch.setBounds(973, 470, 86, 43);
		contentPane.add(saveMatch);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(1085, 470, 86, 43);
		contentPane.add(cancel);
		
		homeTable = new JTable();
		homeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		homeTable.setSelectionBackground(Color.GREEN);
		
		guestTable = new JTable();
		guestTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		homeScrollPane = new JScrollPane(homeTable);
		homeScrollPane.setBounds(10, 49, 434, 416);
		contentPane.add(homeScrollPane);
		
		guestScrollPane = new JScrollPane(guestTable);
		guestScrollPane.setBounds(751, 49, 434, 416);
		contentPane.add(guestScrollPane);
	}

	public MatchView(final IModel model, Team team1, Team team2){
		this();
		this.model = model;
		this.homeTeam = team1;
		this.guestTeam = team2;	
		lblHomeTeam.setText(team1.getName());
		lblGuestTeam.setText(team2.getName());
		
		StatisticModel stmod = new StatisticModelImpl();
		
		for(Player p : team1.getPlayers()){
			stmod.addStatistic(p, new Statistics());
		}
		
		for(Player p : team2.getPlayers()){
			stmod.addStatistic(p, new Statistics());
		}
		
		homeTable.setModel(new MyMatchModel(model, team1, stmod));
		guestTable.setModel(new MyMatchModel(model, team2, stmod));
		final MatchViewController controller = new MatchViewController(model, stmod);
		
		homeTable.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				guestTable.getSelectionModel().removeSelectionInterval(0, 1000);;
			}
		});
		
		guestTable.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				homeTable.getSelectionModel().removeSelectionInterval(0, 1000);
			}
		});
		
		
		addOnePoint.addActionListener(e->{
			
			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();
			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increasePoints(p, 1);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increasePoints(p, 1);
				guestTable.repaint();
			}
		});
		
		removeOnePoint.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreasePoints(p, 1);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreasePoints(p, 1);
				guestTable.repaint();
			}
		});
		
		addTwoPoints.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increasePoints(p, 2);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increasePoints(p, 2);
				guestTable.repaint();
			}
		});
		
		removeTwoPoints.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreasePoints(p, 2);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreasePoints(p, 2);
				guestTable.repaint();
			}
		});
		
		addThreePoints.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increasePoints(p, 3);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increasePoints(p, 3);
				guestTable.repaint();
			}
		});
		
		removeThreePoints.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreasePoints(p, 3);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreasePoints(p, 3);
				guestTable.repaint();
			}
		});		
		
		addOffRebound.addActionListener(e->{
			
			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increaseOffRebounds(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increaseOffRebounds(p);
				guestTable.repaint();
			}
		});
		
		removeOffRebound.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreaseOffRebounds(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreaseOffRebounds(p);
				guestTable.repaint();
			}			
		});

		addDefRebound.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increaseDefRebounds(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increaseDefRebounds(p);
				guestTable.repaint();
			}
		});
		
		removeDefRebound.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();
			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreaseDefRebounds(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreaseDefRebounds(p);
				guestTable.repaint();
			}			
		});

		addAssist.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increseAssists(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increseAssists(p);
				guestTable.repaint();
			}
		});
		
		removeAssist.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();
			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreaseAssists(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreaseAssists(p);
				guestTable.repaint();
			}			
		});

		addBlock.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increaseBlocks(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increaseBlocks(p);
				guestTable.repaint();
			}
		});
		
		removeBlock.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();
			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreaseBlocks(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreaseBlocks(p);
				guestTable.repaint();
			}			
		});

		addPersonalFoul.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.incresePersonalFouls(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.incresePersonalFouls(p);
				guestTable.repaint();
			}
		});
		
		removePersonaFoul.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();
			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreasePeronsalFouls(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreasePeronsalFouls(p);
				guestTable.repaint();
			}			
		});

		addLoseBall.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increaseLoseBall(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increaseLoseBall(p);
				guestTable.repaint();
			}
		});
		
		removeLoseBall.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();
			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreaseLoseBall(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreaseLoseBall(p);
				guestTable.repaint();
			}			
		});

		addSteal.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();

			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.increaseSteals(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.increaseSteals(p);
				guestTable.repaint();
			}
		});
		
		removeSteal.addActionListener(e->{

			int homeindex = homeTable.getSelectedRow();
			int guestindex = guestTable.getSelectedRow();
			Player p ;
			
			if(homeindex>=0){
				p = team1.getPlayers().get(homeindex);
				controller.decreaseSteals(p);
				homeTable.repaint();
			}else if(guestindex>=0){
				p = team2.getPlayers().get(guestindex);
				controller.decreaseSteals(p);
				guestTable.repaint();
			}			
		});

		
		saveMatch.addActionListener(e->{
			
		});
		
		cancel.addActionListener(e->{
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		});
	}
	
	
	

	@Override
	public void attachObserver(MatchViewObserver observer) {
		// TODO Auto-generated method stub
		
	}
}
