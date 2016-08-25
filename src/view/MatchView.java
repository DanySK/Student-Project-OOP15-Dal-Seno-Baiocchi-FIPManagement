package view;

import javax.swing.JPanel;

import controller.ChampionshipController;
import model.Model;
import model.MyTableModel;

public class MatchView extends JPanel {

	/**
	 * Create the panel.
	 */
	private MatchView() {

	}
	
	public MatchView(final Model model){
    	this();
    	/*teamTable.setModel(new MyTableModel(model));
        addTeamBtn.addActionListener(e->{
            AddTeam c = new AddTeam();
            c.attachObserver(new ChampionshipController(model));
            c.repaint();
            c.setVisible(true);
        });
        AddTeam.addActionListener(e->{
        	model.getChampionship().remove(model.getChampionship().toArray()[champTable.getSelectedRow()]);
        	champTable.repaint();
        });
*/
		}
	}
