package controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.IModel;
import model.Model;

/**
 * class used to save and load the data model into a file "Salvataggio.txt"
 * @author francesco
 *
 */

public class Utils {
	
	public static final String FILENAME = "Salvataggio.txt"; 

	public static void save(IModel model) {
		try {
			FileOutputStream fo = new FileOutputStream(FILENAME);
			ObjectOutputStream dos = new ObjectOutputStream(fo);
			dos.writeObject(model);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static IModel loading(){
		try {
			FileInputStream fi = new FileInputStream(FILENAME);
			ObjectInputStream oi = new ObjectInputStream(fi);
			IModel model = (IModel) oi.readObject();
			oi.close();
			return model == null ? new Model() : model;
		} catch (Exception e) {
			return new Model();
		}		
	}
}
