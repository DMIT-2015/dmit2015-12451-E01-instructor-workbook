package dmit2015.faces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("friday")
@RequestScoped
public class FacesWorld {

    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getMessage() {
        return "Hello, " + userInput;
    }

    public String submit() {
        // TODO: Add your business logic here
        return null; // or navigation outcome
    }
}