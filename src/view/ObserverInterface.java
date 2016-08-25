package view;

import controller.LoginController;

public interface ObserverInterface<T>{
    /**
     * Adds an observer of the view
     * @param loginController
     */
    void attachObserver(T observer);
    /**
     * Clear the view 
     */
    void clearInterface();
}
