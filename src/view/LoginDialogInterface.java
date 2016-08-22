package view;

import view.LoginDialog.LoginObserver;

public interface LoginDialogInterface {
    /**
     * Adds an observer of the view
     * @param observer
     */
    void attachObserver(LoginObserver observer);
    /**
     * Clear the view 
     */
    void clearInterface();
}
