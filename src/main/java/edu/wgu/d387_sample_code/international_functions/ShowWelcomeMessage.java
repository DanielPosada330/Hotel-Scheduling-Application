package edu.wgu.d387_sample_code.international_functions;

import java.util.Locale;
import java.util.ResourceBundle;

public class ShowWelcomeMessage implements Runnable{

    // Variable to hold proper locale of either US or CA.
    Locale locale;

    // Constructor for ShowWelcomeMessage
    public ShowWelcomeMessage(Locale locale){
        this.locale = locale;
    }

    // Method for returning welcome message
    public String getShowWelcomeMessage(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("welcome", locale);
        return resourceBundle.getString("welcome");
    }

    // Run function to show thread verification along with thread ID and the welcome message in each language and
    // implement Runnable.
    @Override
    public void run(){
        System.out.println("Thread ID: " + Thread.currentThread().getId() + ", Verify Thread: " + getShowWelcomeMessage());
    }
}
