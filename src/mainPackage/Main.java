package mainPackage;

import model.IModel;
import view.MainView;
import controller.Utils;

public class Main {

	public static void main(String[] args) {
	    IModel model = Utils.loading();
	    MainView view = new MainView();
	    view.setVisible(true);
	}

}
