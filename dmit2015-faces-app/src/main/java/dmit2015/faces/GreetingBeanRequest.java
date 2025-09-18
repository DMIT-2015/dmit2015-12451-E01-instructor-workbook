package dmit2015.faces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import org.omnifaces.util.Messages;

import java.util.Locale;

/**
 * Request-scoped backing bean: new instance per HTTP request.
 * Use for simple actions/data that don't need to persist after the response.
 */
@Named("greetingBeanRequest")
@RequestScoped // New instance per HTTP request; no Serializable required
public class GreetingBeanRequest {

    @NotBlank(message = "Username cannot be blank.")
    @Getter @Setter
    private String username;

    public void sayHello() {
//        Messages.addGlobalInfo("Hello {0}, to Faces world!", username);
        var faker = new Faker(Locale.SIMPLIFIED_CHINESE);
        String message = String.format(
                "Hello %s, your chinese name is %s and your favorite quote is %s",
                username,
                faker.name().fullName(),
                faker.ghostbusters().quote());
        Messages.addGlobalInfo(message);
    }
}
