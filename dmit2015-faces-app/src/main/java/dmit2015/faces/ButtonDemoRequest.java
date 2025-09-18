package dmit2015.faces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.omnifaces.util.Messages;

/**
 * Request-scoped backing bean: new instance per HTTP request.
 * Use for simple actions/data that don't need to persist after the response.
 */
@Named("buttonDemoRequest")
@RequestScoped // New instance per HTTP request; no Serializable required
public class ButtonDemoRequest {

    // Define an actionListener method
    public void handleListener() {
        Messages.addGlobalInfo("Button click via actionListener");
    }

    // Define an action method
    public String submit() {
        Messages.addGlobalInfo("Button click via action");
        return null;
    }

    public String login() {
        return "/index";
    }
}
