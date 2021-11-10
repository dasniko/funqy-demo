package dasniko.quarkus.funqy;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@ApplicationScoped
public class GreetingService {

    public Greeting greet(String value) {
        return new Greeting("Hello, " + value);
    }
}
