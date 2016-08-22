package view;

public interface ObserverInterface<T>{
    /**
     * Adds an observer of the view
     * @param observer
     */
    void attachObserver(T observer);
    /**
     * Clear the view 
     */
    void clearInterface();
}
