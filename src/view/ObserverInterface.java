package view;


public interface ObserverInterface<T>{
    /**
     * Adds an observer of the view
     * @param loginController
     */
    void attachObserver(T observer);
}
