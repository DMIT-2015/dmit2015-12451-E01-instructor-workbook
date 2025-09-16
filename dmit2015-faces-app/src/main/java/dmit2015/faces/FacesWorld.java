package dmit2015.faces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.omnifaces.util.Messages;

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
        Messages.addGlobalInfo("Hello {0} from OmniFaces", userInput);
        Messages.addInfo("feedbackMessage", "Hello userMessage");
        return null; // or navigation outcome
    }
}