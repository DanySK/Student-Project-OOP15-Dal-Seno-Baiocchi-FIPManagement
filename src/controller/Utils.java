package controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.IModel;
import model.Model;

public class Utils {
	
	public static final String FILENAME = "Salvataggio.txt"; 

	public static void save(IModel model) {
		
		try {
			FileOutputStream fo = new FileOutputStream(FILENAME);
			ObjectOutputStream dos = new ObjectOutputStream(fo);
			dos.writeObject(model);
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static IModel loading(){
		try {
			FileInputStream fi = new FileInputStream(FILENAME);
			ObjectInputStream oi = new ObjectInputStream(fi);
			IModel model = (IModel) oi.readObject();
			oi.close();
			return model;
		} catch (Exception e) {
			return new Model();
		}
		
	}
	
}
