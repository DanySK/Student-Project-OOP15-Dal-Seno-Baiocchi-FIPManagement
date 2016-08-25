package observer;

public interface TeamComponentObserver {

	void addComponent(String name, String surname,String role, float height, double cf);
	
	void showComponent(String name, String surname, float height, String role, double cf);
	
	void deleteComponent();
}
